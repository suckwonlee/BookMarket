package kr.ac.Kopo.lsw.bookmarket.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/db")
public class DbSeedController {

    private final JdbcTemplate jdbc;
    private final PasswordEncoder encoder;

    public DbSeedController(JdbcTemplate jdbc, PasswordEncoder encoder) {
        this.jdbc = jdbc;
        this.encoder = encoder;
    }

    /**
     * 예: /BookMarket/db/seed-member?id=user&pw=user1234&name=홍길동&role=USER
     * - role: USER/ADMIN (기본 USER)
     */
    @GetMapping("/seed-member")
    public Map<String, Object> seedMember(@RequestParam String id,
                                          @RequestParam String pw,
                                          @RequestParam(defaultValue = "USER") String role,
                                          @RequestParam(defaultValue = "") String name) {
        Map<String, Object> res = new HashMap<>();

        // 중복 체크
        Integer exists = jdbc.queryForObject(
                "select count(*) from member where member_id = ?",
                Integer.class, id);
        if (exists != null && exists > 0) {
            res.put("ok", true);
            res.put("action", "skip (already exists)");
            res.put("member_id", id);
            return res;
        }

        // 새 PK 번호: 현재 최대 + 1
        Long nextNum = jdbc.queryForObject("select coalesce(max(num),0)+1 from member", Long.class);
        if (nextNum == null) nextNum = 1L;

        String hashed = encoder.encode(pw);

        // INSERT
        jdbc.update(
                "insert into member (num, member_id, password, role, name) values (?,?,?,?,?)",
                nextNum, id, hashed, role, name
        );

        // member_seq 보정(중복 방지용)
        jdbc.update(
                "update member_seq set next_val = greatest(next_val, ?)",
                nextNum + 1
        );

        res.put("ok", true);
        res.put("action", "insert");
        res.put("num", nextNum);
        res.put("member_id", id);
        res.put("role", role);
        res.put("name", name);
        res.put("bcrypt_length", hashed.length());
        return res;
    }
}
