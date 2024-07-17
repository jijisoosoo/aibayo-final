package com.aico.aibayo.control;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @GetMapping("/admin/scheduleMain")
    public String adminScheduleMain(){ return "/schedule/admin/scheduleMain"; }

    @GetMapping("/admin/scheduleWrite")
    public String adminScheduleWrite(){ return "/schedule/admin/scheduleWrite"; }

    @GetMapping("/user/scheduleMain")
    public String userScheduleWrite(){ return "/schedule/user/scheduleMain"; }
}
