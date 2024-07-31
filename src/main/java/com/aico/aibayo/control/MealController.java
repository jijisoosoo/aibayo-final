package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meal")
public class MealController {
    @GetMapping("/admin/list")
    public String adminList() {
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
