package com.aico.aibayo.control;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.service.member.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class MemberController {
    private final MemberServiceImpl memberService;


    @PostMapping("/member/signUp")
    public String signUpProcess(MemberDto memberDto) {
        memberService.signUpProcess(memberDto);

        return "ok";
    }
}
