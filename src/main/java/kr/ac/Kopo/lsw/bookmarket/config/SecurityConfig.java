package kr.ac.Kopo.lsw.bookmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import kr.ac.Kopo.lsw.bookmarket.service.MemberService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig {

	private final JdbcTemplate jdbc;

	public SecurityConfig(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, MemberService memberService) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
						.requestMatchers("/login", "/loginfailed", "/home", "/").permitAll()
						.requestMatchers("/member/add").permitAll()
						.anyRequest().authenticated()
				)
				.userDetailsService(memberService)
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/login")      // login.html의 th:action="@{/login}"과 일치
						.usernameParameter("username")     // login.html의 name="username"
						.passwordParameter("password")     // login.html의 name="password"
						.failureUrl("/login?error")
						.successHandler((req, res, auth) -> {
							// 로그인 직후 헤더가 요구하는 세션 값 보장 (name 미존재로 인한 500 방지)
							String memberId = auth.getName();
							String name = null;
							try {
								name = jdbc.queryForObject(
										"select name from member where member_id=?",
										String.class, memberId
								);
							} catch (Exception ignored) {}

							Map<String, Object> info = new HashMap<>();
							info.put("memberId", memberId);
							info.put("name", name); // header.html에서 requireNonNull로 쓰는 경우 대비
							req.getSession(true).setAttribute("userLoginInfo", info);

							// 컨텍스트패스(/BookMarket) 안전 적용
							res.sendRedirect(req.getContextPath() + "/home");
						})
						.permitAll()
				)
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login")
						.invalidateHttpSession(true)
						.clearAuthentication(true)
						.deleteCookies("JSESSIONID")
				);

		// CSRF는 정상 유지 (login.html에 히든 필드 이미 있음)
		return http.build();
	}
}
