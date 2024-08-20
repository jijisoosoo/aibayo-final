package com.aico.aibayo.control;

import com.aico.aibayo.dto.RegisterKinderDto;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.entity.RegisterKinderEntity;
import com.aico.aibayo.service.kinder.KinderService;
import com.aico.aibayo.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class ApiMemberController {
    private final MemberService memberService;
    private final KinderService kinderService;

    @PutMapping("/select")
    public ResponseEntity<RegisterKinderDto>kinderDto(
            Long kinderNo,
            @ModelAttribute("loginInfo") MemberDto memberDto
    ){
        RegisterKinderDto result = kinderService.getKinderDtoById(kinderNo);
        memberDto.setKinderNo(kinderNo);
        return result == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(result);
    }

}
