package kr.ac.Kopo.lsw.bookmarket.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {


	@GetMapping("/login")
	public String login(HttpSession session) {
		Object u = session.getAttribute("userLoginInfo");
		if (u == null) {
			Map<String, Object> stub = new HashMap<>();
			// 이미 인증돼 있다면 이름 채워 넣고, 아니면 빈 문자열
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = (auth != null && auth.isAuthenticated()
					&& !(auth instanceof AnonymousAuthenticationToken)) ? auth.getName() : "";
			stub.put("memberId", username);
			session.setAttribute("userLoginInfo", stub);
		}
		return "login"; // 기존 뷰 이름 유지
	}
 
   
	@GetMapping("/loginfailed")
	public String loginerror(Model model) { 
      model.addAttribute("error", "true");   
      return "login";                      
   }   
	
	@GetMapping("/logout")
	public String logout(Model model) { 
		return "login";  
	}
	
}
