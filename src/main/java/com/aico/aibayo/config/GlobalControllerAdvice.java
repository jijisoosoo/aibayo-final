package com.aico.aibayo.config;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {
    private final MemberService memberService;
    private final JWTUtil jwtUtil;

    @ModelAttribute
    public MemberDto addAttributes(HttpServletRequest request, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            return null; // 로그인되지 않은 경우 null을 반환하여 모델에 추가하지 않음
        }
//        String username = (String) request.getAttribute("username");
//        String username = "admin";
        String token = getTokenFromCookies(request.getCookies());
        String username = jwtUtil.getUsername(token);
        log.info("loginUser: {}", username);
        MemberDto memberDto = memberService.findByUsername(username);
//        memberDto.setKinderNo(1L);

        model.addAttribute("loginInfo", memberDto);
        log.info("loginInfo: {}", memberDto);

        return memberDto;
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
