package com.aico.aibayo.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @GetMapping("/admin/teacherMain")
    public String adminTeacherMain() {
        return "/teacherManage/teacherMain";
    }

    @GetMapping("/admin/teacherProfile")
    public String adminTeacherProfile() {
        return "/teacherManage/teacherProfile";
    }





}
