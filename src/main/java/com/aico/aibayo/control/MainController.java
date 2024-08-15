package com.aico.aibayo.control;

import com.aico.aibayo.common.SggInfoEnum;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {
    private final JWTUtil jwtUtil;
    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("/")
    public String mainPage() {
        return "/index";
    }

    @GetMapping("/admin")
    public String adminMain(HttpServletRequest request, HttpServletResponse response,
                            @ModelAttribute("loginInfo") MemberDto loginInfo, Model model) {
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

        // 유치원에 맞는 위치의 미세먼지 관측소 찾기
        setStationName(loginInfo, model);

        return "/admin/main/main";
    }

    @GetMapping("/user")
    public String userMain(HttpServletRequest request, HttpServletResponse response,
                           @ModelAttribute("loginInfo") MemberDto loginInfo, Model model) {
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

        // 유치원에 맞는 미세먼지 정보 세팅
        setStationName(loginInfo, model);

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

    private void setStationName(MemberDto loginInfo, Model model) {
        String kinderSggCode = memberService.getKinderSggListByKinderNo(loginInfo.getKinderNo());
        String stationName = SggInfoEnum.findByKinderSggCode(kinderSggCode).getStationName();
        model.addAttribute("stationName", stationName);
    }
}
