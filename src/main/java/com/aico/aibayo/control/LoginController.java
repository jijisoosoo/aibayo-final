package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/signIn")
    public String signIn() {
        return "login/signIn";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "login/signUp";
    }

    @GetMapping("/signInFindPw")
    public String signInFindPw() {
        return "login/signInFindPw";
    }


}
