package com.aico.aibayo.control;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {
    private final MemberService memberService;
    private final JWTUtil jwtUtil;

    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model) {
        String token = getTokenFromCookies(request.getCookies());
        String username = jwtUtil.getUsername(token);
        log.info("loginUser: {}", username);
        MemberDto memberDto = memberService.findByUsername(username);

        // 학부모일 경우 추가 작업(추가 수정 필요)

        model.addAttribute("loginInfo", memberDto);
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

    @GetMapping("/admin/list")
    public String adminList() {
        return "/admin/meal/list";
    }

    @GetMapping("/user/list")
    public String userList() {
        return "/user/meal/list";
    }

    @GetMapping("/admin/write")
    public String writeForm() {
        return "/admin/meal/writeForm";
    }

    @GetMapping("/admin/modify")
    public String modifyForm() {
        return "/admin/meal/modifyForm";
    }
}
