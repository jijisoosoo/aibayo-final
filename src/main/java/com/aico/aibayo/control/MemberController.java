package com.aico.aibayo.control;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.service.member.MemberServiceImpl;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberServiceImpl memberService;




    @GetMapping("/signIn")
    public String signIn() {
        return "member/signIn";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "member/signUp";
    }

    @PostMapping("/signUp")
    @ResponseBody
    public String signUpProcess(MemberDto memberDto) {
        MemberDto dto = memberService.signUpProcess(memberDto);

        return "ok";
    }

    @GetMapping("/signUpKid")
    public String signUpKid() {
        return "member/signUpKid";
    }

    @GetMapping("/signInFindPw")
    public String signInFindPw() {
        return "member/signInFindPw";
    }

    @GetMapping("signInResetPw")
    public String singInResetPw() { return "member/signInResetPw"; }

    @GetMapping("/myPage")
    public String myPage() {
        return "member/myPage";
    }



    @GetMapping("/passwordExist")
    public String passwordExist() {
        


        return null;
    }


}
