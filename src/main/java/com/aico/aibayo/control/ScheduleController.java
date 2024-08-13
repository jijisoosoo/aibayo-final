package com.aico.aibayo.control;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.schedule.ScheduleDto;
import com.aico.aibayo.service.member.MemberService;
import com.aico.aibayo.service.schedule.ScheduleService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final MemberService memberService;
    private final ScheduleService scheduleService;

    @GetMapping("/admin/scheduleMain")
    public String adminScheduleMain(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model){

        List<ScheduleDto> schedules = scheduleService.getAllByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("schedules", schedules);

        return "/admin/schedule/scheduleMain";
    }

    @GetMapping("/admin/scheduleWrite")
    public String adminScheduleWrite(@ModelAttribute("loginInfo") MemberDto loginInfo){
        return "/admin/schedule/scheduleWrite";
    }

    @GetMapping("/user/scheduleMain")
    public String userScheduleWrite(){ return "/user/schedule/scheduleMain"; }
}
