package com.aico.aibayo.control;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.entity.ClassEntity;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.service.classManage.ClassService;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceController {
    private final JWTUtil jwtUtil;
    private final MemberService memberService;
    private final ClassService classService;

    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model) {
        String token = getTokenFromCookies(request.getCookies());
        if (token == null || token.isEmpty()) {
            log.error("JWT token is missing");
            // 여기서 예외를 던지거나, 적절히 처리합니다.
            return;
        }

        String username = jwtUtil.getUsername(token);
        log.info("loginUser: {}", username);
        MemberDto memberDto = memberService.findByUsername(username);

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

    @GetMapping("/admin/main")
    public String adminMain() {
        return "admin/attendance/main";
    }

    @GetMapping("/admin/detailToday")
    public String detailToday(@ModelAttribute("loginInfo") MemberDto memberDto, Model model) {
        List<ClassEntity> classList = classService.getClassList(memberDto.getKinderNo());

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));

        model.addAttribute("date", date);
        model.addAttribute("classList", classList);
        log.info("day : detailToday");
        return "admin/attendance/detailToday";
    }

    @GetMapping("/admin/detailBefore")
    public String detailBefore(Model model) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        model.addAttribute("date", date);
        log.info("day : detailBefore");
        return "admin/attendance/detailBefore";
    }

    @GetMapping("/admin/detailAfter")
    public String detailAfter(Model model) {
        // 현재 날짜와 시간 가져오기 -> 날짜 출력 포맷 -> 포매팅
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        model.addAttribute("date", date);

        log.info("day : detailAfter");
        return "admin/attendance/detailAfter";
    }

    @GetMapping("/admin/write")
    public String detailWrite(Model model) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        model.addAttribute("date", date);

        return "admin/attendance/detailWrite";
    }
}
