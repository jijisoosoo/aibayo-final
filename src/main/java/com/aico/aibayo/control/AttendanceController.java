package com.aico.aibayo.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @GetMapping("/admin/main")
    public String adminMain() {
        return "admin/attendance/main";
    }

    @GetMapping("/admin/detailToday")
    public String detailToday(Model model) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        model.addAttribute("date", date);
        log.info("day : detailToday");
        return "admin/attendance/detailToday";
    }

    @GetMapping("/admin/detailBefore")
    public String detailBefore(Model model) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        model.addAttribute("date", date);
        log.info("day : detailBefore");
        return "admin/attendance/detailBefore";
    }

    @GetMapping("/admin/detailAfter")
    public String detailAfter(Model model) {
        // 현재 날짜와 시간 가져오기 -> 날짜 출력 포맷 -> 포매팅
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        model.addAttribute("date", date);

        log.info("day : detailAfter");
        return "admin/attendance/detailAfter";
    }

    @GetMapping("/admin/write")
    public String detailWrite(Model model) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        model.addAttribute("date", date);

        return "admin/attendance/detailWrite";
    }
}
