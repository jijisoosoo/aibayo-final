package com.aico.aibayo.service.member;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.MemberSearchCondition;
import com.aico.aibayo.entity.MemberEntity;
import com.aico.aibayo.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public MemberDto signUpProcess(MemberDto memberDto) {

        String name = memberDto.getName();
        String role = memberDto.getRole();
        String username = memberDto.getUsername(); // email
        String password = memberDto.getPassword();
        String phone = memberDto.getPhone();

        Boolean isExist = memberRepository.existsByUsername(username); // email이 있으면

        if (isExist) { // 이미 존재하는 이메일이 있으면 종료 (회원가입 실패)
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(name);
        memberEntity.setRole("ROLE_ADMIN"); // 차후에 수정
        memberEntity.setUsername(username);
        memberEntity.setPassword(bCryptPasswordEncoder.encode(password));
        memberEntity.setPhone(phone);
        memberEntity.setRegDate(LocalDateTime.now());
        memberEntity.setLatestLogDate(LocalDateTime.now());

        memberRepository.save(memberEntity);

        // 새로운 DTO 생성 및 반환
        MemberDto newMemberDto = new MemberDto();
        newMemberDto.setName(name);
        newMemberDto.setRole("ROLE_ADMIN");
        newMemberDto.setUsername(username);
        newMemberDto.setPhone(phone);
        newMemberDto.setRegDate(LocalDateTime.now());
        newMemberDto.setLatestLogDate(LocalDateTime.now());

        return newMemberDto;
    }

    @Override
    public List<MemberDto> getAllByKidNo(Long kidNo) {
        return memberRepository.findAllByKidNo(kidNo);
    }

    @Override
    public MemberDto getByIdAndKidNo(MemberSearchCondition condition) {
        return memberRepository.findByIdAndKidNo(condition);
    }
}
