package com.aico.aibayo.control;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.teacher.teacherDto;
import com.aico.aibayo.service.teacher.teacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final teacherService teacherService;

    @GetMapping("/list")
    public String adminTeacherMain(Model model) {
        List<MemberDto> teachers = teacherService.getAllByKinderNo(1L);
        model.addAttribute("teachers", teachers);
        return "/admin/teacher/teacherMain";
    }

    @GetMapping("/admin/teacherProfileAccept")
    public String adminTeacherProfileAccept() {
        return "/admin/teacher/teacherProfileAccept";
    }

    @GetMapping("/admin/teacherProfileWait")
    public String adminTeacherProfileWait() {
        return "/admin/teacher/teacherProfileWait";
    }



}
