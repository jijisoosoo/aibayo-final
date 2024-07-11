package com.aico.aibayo.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @GetMapping("/admin/mainDone")
    public String adminMainDone() {
        return "/teacherManage/mainDone";
    }

    @GetMapping("/admin/mainWaiting")
    public String adminMainWaiting() {
        return "/teacherManage/mainWaiting";
    }

    @GetMapping("/admin/mainInvited")
    public String adminMainInvited() {
        return "/teacherManage/mainInvited";
    }

    @GetMapping("/admin/teacherProfile")
    public String adminTeacherProfile() {
        return "/teacherManage/teacherProfile";
    }





}
