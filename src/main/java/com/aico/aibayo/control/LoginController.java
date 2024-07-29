package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class LoginController {

    @GetMapping("/signIn")
    public String signIn() {
        return "member/signIn";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "member/signUp";
    }

    @GetMapping("/signUpKid")
    public String signUpKid() {
        return "member/signUpKid";
    }

    @GetMapping("/signInFindPw")
    public String signInFindPw() {
        return "member/signInFindPw";
    }

    @GetMapping("/myPage")
    public String myPage() {
        return "member/myPage";
    }

}
