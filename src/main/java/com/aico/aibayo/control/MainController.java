package com.aico.aibayo.control;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    @GetMapping("/admin")
    public String adminMain(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("role", "admin");

        return "/admin/main/main";
    }

    @GetMapping("/user")
    public String userMain(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("role", "user");

        return "/user/main/main";
    }
}
