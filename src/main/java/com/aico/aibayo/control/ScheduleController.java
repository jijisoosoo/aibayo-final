package com.aico.aibayo.control;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping
public class ScheduleController {

    @GetMapping("/admin/scheduleMain")
    public String adminScheduleMain(){ return "/admin/schedule/scheduleMain"; }

    @GetMapping("/admin/scheduleWrite")
    public String adminScheduleWrite(){ return "/admin/schedule/scheduleWrite"; }

    @GetMapping("/user/scheduleMain")
    public String userScheduleWrite(){ return "/user/schedule/scheduleMain"; }
}
