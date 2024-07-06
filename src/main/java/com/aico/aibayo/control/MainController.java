package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    @GetMapping("/admin")
    public String adminMain() {
        return "main/admin/main";
    }

    @GetMapping("/user")
    public String userMain() {
        return "main/user/main";
    }
}
