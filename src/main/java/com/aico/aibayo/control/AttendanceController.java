package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @GetMapping("/admin/main")
    public String adminMain() {
        return "attendance/admin/main";
    }
}
