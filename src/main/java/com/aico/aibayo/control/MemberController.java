package com.aico.aibayo.control;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.service.member.MemberServiceImpl;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberServiceImpl memberService;


    @PostMapping("/member/signUp")
    @ResponseBody
    public String signUpProcess(MemberDto memberDto) {
        MemberDto dto = memberService.signUpProcess(memberDto);

        return "ok";
    }

}
