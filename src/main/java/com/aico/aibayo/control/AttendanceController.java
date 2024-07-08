package com.aico.aibayo.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @GetMapping("/admin/main")
    public String adminMain() {
        return "attendance/admin/main";
    }

    @GetMapping("/admin/detailToday")
    public void detailToday() {
        log.info("detailToday");
    }

    @GetMapping("/admin/detailBefore")
    public void detailBefore() {
        log.info("detailBefore");
    }

    @GetMapping("/admin/detailAfter")
    public void detailAfter() {
        log.info("detailAfter");
    }
}
