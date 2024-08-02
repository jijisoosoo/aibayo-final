package com.aico.aibayo.control;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.teacher.TeacherSearchCondition;
import com.aico.aibayo.dto.teacher.teacherDto;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.member.MemberService;
import com.aico.aibayo.service.teacher.teacherService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final JWTUtil jwtUtil;

    private final teacherService teacherService;
    private final ClassService classService;
    private final MemberService memberService;

    // 로그인 정보 가져오기
    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model) {
        String token = getTokenFromCookies(request.getCookies());
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

    // 일반조회
    @GetMapping("/list")
    public String teacherMain(Model model) {
        TeacherSearchCondition condition = new TeacherSearchCondition();
        return getConditionAndGoMain(model, condition);
    }

    // 일반조회 - searchcondition 적용해서
    public String getConditionAndGoMain(Model model, TeacherSearchCondition condition) {
        MemberDto loginInfo = (MemberDto)model.getAttribute("loginInfo");
        condition.setKinderNo(loginInfo.getKinderNo());

        condition.setAcceptStatus(AcceptStatusEnum.ACCEPT.getStatus());
        List<teacherDto> acceptedTeacherList = teacherService.getAllByKinderNo(condition);
        model.addAttribute("acceptedTeacherList", acceptedTeacherList);

        condition.setAcceptStatus(AcceptStatusEnum.WAIT.getStatus());
        List<teacherDto> waitingTeacherList = teacherService.getAllByKinderNo(condition);
        model.addAttribute("waitingTeacherList", waitingTeacherList);

        condition.setAcceptStatus(AcceptStatusEnum.INVITE.getStatus());
        List<teacherDto> invitedTeacherList = teacherService.getAllByKinderNo(condition);
        model.addAttribute("invitedTeacherList", invitedTeacherList);

        List<ClassDto> classList = classService.getByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classList", classList);

        return "/admin/teacher/teacherMain";
    }

//    @GetMapping("/list")
    public String mainByClass(Model model) {
        TeacherSearchCondition condition = new TeacherSearchCondition();
        return getConditionAndGoMainByClass(model, condition);
    }

    // 일반조회 - searchcondition 적용해서
    public String getConditionAndGoMainByClass(Model model, TeacherSearchCondition condition) {
        MemberDto loginInfo = (MemberDto)model.getAttribute("loginInfo");
        condition.setKinderNo(loginInfo.getKinderNo());

        condition.setAcceptStatus(AcceptStatusEnum.ACCEPT.getStatus());
        List<teacherDto> acceptedTeacherList = teacherService.getAllByKinderNo(condition);
        model.addAttribute("acceptedTeacherList", acceptedTeacherList);

        List<ClassDto> classList = classService.getByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classList", classList);

        return "/admin/teacher/teacherMain";
    }


    @GetMapping("/teacherProfileAccept/{id}")
    public String adminTeacherProfileAccept() {
        return "/admin/teacher/teacherProfileAccept";
    }

    @GetMapping("/admin/teacherProfileWait/{id}")
    public String adminTeacherProfileWait() {
        return "/admin/teacher/teacherProfileWait";
    }



}
