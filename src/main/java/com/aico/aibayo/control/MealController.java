package com.aico.aibayo.control;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {
    private final MemberService memberService;

    @GetMapping("/admin/list")
    public String adminList(@ModelAttribute("loginInfo") MemberDto loginInfo) {

        return "/admin/meal/list";
    }

    @GetMapping("/user/list")
    public String userList() {
        return "/user/meal/list";
    }

    @GetMapping("/admin/write")
    public String writeForm() {
        return "/admin/meal/writeForm";
    }

    @GetMapping("/admin/modify")
    public String modifyForm() {
        return "/admin/meal/modifyForm";
    }
}
