package com.aico.aibayo.control;

import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.schedule.ScheduleDto;
import com.aico.aibayo.dto.schedule.ScheduleSearchCondition;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.member.MemberService;
import com.aico.aibayo.service.schedule.ScheduleService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final MemberService memberService;
    private final ScheduleService scheduleService;
    private final ClassService classService;

    @GetMapping("/admin/scheduleMain")
    public String adminScheduleMain(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model){

        ScheduleSearchCondition condition = new ScheduleSearchCondition();
        condition.setKinderNo(loginInfo.getKinderNo());
        List<ScheduleDto> schedules = scheduleService.getAllByKinderNo(condition);
        model.addAttribute("schedules", schedules);
        List<ClassDto> classList = classService.getByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classList", classList);

        return "/admin/schedule/scheduleMain";
    }

    @PostMapping("/admin/scheduleMainByClass")
    public String adminscheduleMainByClass(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                                         @RequestBody ScheduleSearchCondition condition){

        System.out.println("condition : " + condition);
        List<ScheduleDto> classSchedules = scheduleService.getListByClass(condition);
        model.addAttribute("classSchedules", classSchedules);

        return "/admin/schedule/scheduleMain";
    }

    @PostMapping("/admin/scheduleMainByDay")
    public String adminScheduleMainByDay(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                                         @RequestBody ScheduleSearchCondition condition){

        List<ScheduleDto> daySchedules = scheduleService.getListByDay(condition);
        model.addAttribute("daySchedules", daySchedules);

        return "/admin/schedule/scheduleMain";
    }

    @GetMapping("/admin/scheduleWrite")
    public String adminScheduleWrite(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model){

        return "/admin/schedule/scheduleWrite";
    }

    @GetMapping("/user/scheduleMain")
    public String userScheduleWrite(){ return "/user/schedule/scheduleMain"; }
}
