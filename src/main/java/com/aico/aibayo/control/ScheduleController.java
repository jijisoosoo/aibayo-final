package com.aico.aibayo.control;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.service.member.MemberService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final MemberService memberService;

    @GetMapping("/admin/scheduleMain")
    public String adminScheduleMain(@ModelAttribute("loginInfo") MemberDto loginInfo){
        return "/admin/schedule/scheduleMain";
    }

    @GetMapping("/admin/scheduleWrite")
    public String adminScheduleWrite(){ return "/admin/schedule/scheduleWrite"; }

    @GetMapping("/user/scheduleMain")
    public String userScheduleWrite(){ return "/user/schedule/scheduleMain"; }
}
