package com.aico.aibayo.control;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "/index";
    }


    @GetMapping("/admin")
    public String adminMain(HttpSession session) {
        // 세션 정보 검색
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        String role = auth.getAuthority();

        // 세션에 사용자 이름과 역할 저장
        session.setAttribute("username", name);
        session.setAttribute("role", role);

        return "/main/admin/main";
    }

    @GetMapping("/user")
    public String userMain(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("role", "user");

        return "/main/user/main";
    }
}
