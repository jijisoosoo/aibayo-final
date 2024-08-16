package com.aico.aibayo.control;

import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.schedule.ScheduleDto;
import com.aico.aibayo.dto.schedule.ScheduleSearchCondition;
import com.aico.aibayo.service.ScheduleClassService;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.member.MemberService;
import com.aico.aibayo.service.schedule.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final MemberService memberService;
    private final ScheduleService scheduleService;
    private final ScheduleClassService scheduleClassService;
    private final ClassService classService;

    @GetMapping("/admin/scheduleMain")
    public String adminScheduleMain(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model){

        ScheduleSearchCondition condition = new ScheduleSearchCondition();
        condition.setKinderNo(loginInfo.getKinderNo());
        List<ScheduleDto> schedules = scheduleService.getAllByKinderNo(condition);
        model.addAttribute("schedules", schedules);
        for(ScheduleDto schedule : schedules){
            List<ClassDto> scheduledClass = scheduleClassService.getClassByScheduleNo(schedule.getScheduleNo());
            schedule.setClassList(scheduledClass);
        }
        List<ClassDto> classList = classService.getByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classList", classList);

        return "/admin/schedule/scheduleMain";
    }

    @PostMapping("/admin/scheduleMainByClass")
    public String adminscheduleMainByClass(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                                         @RequestBody ScheduleSearchCondition condition){

        System.out.println("condition : " + condition);
        List<ScheduleDto> classSchedules = scheduleService.getListByClass(condition);
        for(ScheduleDto schedule : classSchedules){
            List<ClassDto> scheduledClass = scheduleClassService.getClassByScheduleNo(schedule.getScheduleNo());
            schedule.setClassList(scheduledClass);
        }
        model.addAttribute("classSchedules", classSchedules);

        return "/admin/schedule/scheduleMain";
    }

    @PostMapping("/admin/scheduleMainByDay")
    public String adminScheduleMainByDay(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                                         @RequestBody ScheduleSearchCondition condition){
        List<ScheduleDto> daySchedules = scheduleService.getListByDay(condition);
        for(ScheduleDto schedule : daySchedules){
            List<ClassDto> scheduledClass = scheduleClassService.getClassByScheduleNo(schedule.getScheduleNo());
            schedule.setClassList(scheduledClass);
        }
        model.addAttribute("daySchedules", daySchedules);
        return "/admin/schedule/scheduleMain";
    }

    @GetMapping("/admin/scheduleWrite")
    public String adminScheduleWrite(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model){

        List<ClassDto> classList = classService.getByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classList", classList);

        return "/admin/schedule/scheduleWrite";
    }

    @GetMapping("/admin/scheduleModify/{scheduleNo}")
    public String adminScheduleByScheduleNo(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                                            @PathVariable Long scheduleNo){
        ScheduleSearchCondition condition = new ScheduleSearchCondition();
        condition.setScheduleNo(scheduleNo);
        ScheduleDto schedule = scheduleService.getOneByScheduleNo(condition);

        List<ClassDto> scheduledClass = scheduleClassService.getClassByScheduleNo(scheduleNo);
        schedule.setClassList(scheduledClass);
        model.addAttribute("schedule", schedule);

        List<ClassDto> classList = classService.getByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classList", classList);
        return "/admin/schedule/scheduleModify";
    }


    @PostMapping("/admin/addSchedule")
    @ResponseBody
    public void writeOk(@ModelAttribute("loginInfo") MemberDto loginInfo,
                        @RequestBody Map<String, Object> requestBody) {

        requestBody.put("writer", loginInfo.getId());
        requestBody.put("kinderNo", loginInfo.getKinderNo());
        scheduleService.insertSchedule(requestBody);
    }


    @GetMapping("/user/scheduleMain")
    public String userScheduleWrite(){ return "/user/schedule/scheduleMain"; }
}
