package com.aico.aibayo.service.member;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.entity.MemberEntity;
import com.aico.aibayo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public void  signUpProcess(MemberDto memberDto) {

        String name = memberDto.getName();
        String role = memberDto.getRole();
        String username = memberDto.getUsername(); // email
        String password = memberDto.getPassword();
        String phone = memberDto.getPhone();

        Boolean isExist = memberRepository.existsByUsername(username); // email이 있으면

        if (isExist) { // 이미 존재하는 이메일이 있으면 종료 (회원가입 실패)
            return;
        }

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(name);
        memberEntity.setRole("ROLE_ADMIN"); // 차후에 수정
        memberEntity.setUsername(username);
        memberEntity.setPassword(bCryptPasswordEncoder.encode(password));
        memberEntity.setPhone(phone);

        memberRepository.save(memberEntity);
    }
}
