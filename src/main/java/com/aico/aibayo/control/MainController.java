package com.aico.aibayo.control;

import com.aico.aibayo.jwt.JWTUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    private final JWTUtil jwtUtil;

    public MainController(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/")
    public String mainPage() {
        return "/index";
    }

    @GetMapping("/admin")
    public String adminMain(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("adminMain()=======================================");

        // 쿠키에서 JWT 토큰을 가져옴
        String token = getTokenFromCookies(request.getCookies());
        if (token == null || jwtUtil.isExpired(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return "redirect:/login";
        }

        // JWT 토큰에서 사용자 정보 추출
        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        if (!"ROLE_ADMIN".equals(role) && !"ROLE_PRINCIPAL".equals(role) && !"ROLE_TEACHER".equals(role)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return "redirect:/login";
        }

        // 사용자 정보를 request에 저장 (필요 시 사용)
        request.setAttribute("username", username);
        request.setAttribute("role", role);

        return "/admin/main/main";
    }

    @GetMapping("/user")
    public String userMain(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("userMain()=======================================");


        // 쿠키에서 JWT 토큰을 가져옴
        String token = getTokenFromCookies(request.getCookies());
        if (token == null || jwtUtil.isExpired(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return "redirect:/login";
        }

        // JWT 토큰에서 사용자 정보 추출
        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        System.out.println("user role : " + role);

        if (!"ROLE_USER".equals(role)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return "redirect:/login";
        }

        // 사용자 정보를 request에 저장 (필요 시 사용)
        request.setAttribute("username", username);
        request.setAttribute("role", role);

        return "/user/main/main";
    }

    private String getTokenFromCookies(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwt".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
