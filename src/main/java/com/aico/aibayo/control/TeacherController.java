package com.aico.aibayo.control;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.dto.kid.KidSearchCondition;
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
import org.springframework.web.bind.annotation.*;

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

    // 일반 조회
    @GetMapping("/list")
    public String teacherMain(Model model) {
        TeacherSearchCondition condition = new TeacherSearchCondition();
        return getConditionAndGoMain(model, condition);
    }

    // 반 별 조회 - condition에 classNo 추가
    @PostMapping("/listByClass")
    public String mainByClass(@RequestBody TeacherSearchCondition condition,
                              Model model) {
        log.info("search: {}", condition);

        return getConditionAndGoMain(model, condition);
    }

    // 일반조회 - searchcondition 적용해서
    public String getConditionAndGoMain(Model model, TeacherSearchCondition condition) {
        MemberDto loginInfo = (MemberDto)model.getAttribute("loginInfo");
        condition.setKinderNo(loginInfo.getKinderNo());

        condition.setAcceptStatus(AcceptStatusEnum.ACCEPT.getStatus());
        List<teacherDto> acceptedTeacherList = teacherService.getAcceptedTeacherByKinderNoAndClassNo(condition);
        model.addAttribute("acceptedTeacherList", acceptedTeacherList);
        model.addAttribute("condition", condition);
        log.info("ACCEPT: {}", condition);
        log.info("ACCEPTlist: {}", acceptedTeacherList.toString());

        // acceptStatus wait, invite에는 condition의 ClassNo = null로 재설정해서 addAttribute
        condition.setClassNo(null);

        condition.setAcceptStatus(AcceptStatusEnum.WAIT.getStatus());
        List<teacherDto> waitingTeacherList = teacherService.getAllByKinderNo(condition);
        model.addAttribute("waitingTeacherList", waitingTeacherList);
        log.info("WAIT: {}", condition);


        condition.setAcceptStatus(AcceptStatusEnum.INVITE.getStatus());
        List<teacherDto> invitedTeacherList = teacherService.getAllByKinderNo(condition);
        model.addAttribute("invitedTeacherList", invitedTeacherList);
        log.info("INVITE: {}", condition);

        List<ClassDto> classList = classService.getByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classList", classList);

        return "/admin/teacher/teacherMain";
    }


    @GetMapping ("/teacherProfileAccept/{id}")
    public String acceptedTeacherProfile(Model model, @PathVariable Long id) {
        MemberDto loginInfo = (MemberDto)model.getAttribute("loginInfo");

        teacherDto teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);

        List<ClassDto> classList = classService.getAllByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classList", classList);

        List<ClassDto> addableClassList = classService.getAddableClassByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("addableClassList", addableClassList);

        List<ClassDto> assignedClassList = classService.getClassByKinderNoAndTeacherId(loginInfo.getKinderNo(), id);
        model.addAttribute("assignedClassList", assignedClassList);

        return "/admin/teacher/teacherProfileAccept";
    }

    @GetMapping("/admin/teacherProfileWait/{id}")
    public String adminTeacherProfileWait() {
        return "/admin/teacher/teacherProfileWait";
    }



}
