package com.aico.aibayo.control;

import com.aico.aibayo.dto.classKid.ClassKidDto;
import com.aico.aibayo.dto.classTeacher.ClassTeacherDto;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.entity.ClassEntity;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.repository.classKid.ClassKidRepository;
import com.aico.aibayo.repository.classManage.ClassRepository;
import com.aico.aibayo.repository.classTeacher.ClassTeacherRepository;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.classManage.ClassServiceImpl;
import com.aico.aibayo.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/classManage")
@RequiredArgsConstructor
@Slf4j
public class ClassManageController {
    private final ClassService classService;
    private final JWTUtil jwtUtil;
    private final MemberService memberService;



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


    @GetMapping("/main")
    public String mainPage(@ModelAttribute("loginInfo") MemberDto memberDto, Model model) {
        Long kinderNo = memberDto.getKinderNo();

        List<ClassEntity> classList = classService.getClassList(kinderNo);

        model.addAttribute("classList", classList);
        model.addAttribute("kinderNo", kinderNo);

        return "/admin/classManage/main";
    }

    @GetMapping("/detail/{classNo}")
    public ResponseEntity<Map<String, Object>> detailPage(@PathVariable Long classNo) {

        List<ClassKidDto> classKid = classService.getClassKid(classNo);
        List<ClassTeacherDto> classTeacher = classService.getClassTeacher(classNo);

        Map<String, Object> response = new HashMap<>();
        response.put("classKid", classKid);
        response.put("classTeacher", classTeacher);

        return ResponseEntity.ok(response);
    }

}
