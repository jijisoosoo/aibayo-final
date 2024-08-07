package com.aico.aibayo.service.member;

import com.aico.aibayo.common.MemberStatusEnum;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.MemberSearchCondition;
import com.aico.aibayo.entity.MemberEntity;
import com.aico.aibayo.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
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
        memberEntity.setStatus(MemberStatusEnum.TEMP.getStatus()); // wait
        memberRepository.save(memberEntity);


        // 새로운 DTO 생성 및 반환
        MemberDto newMemberDto = new MemberDto();
        newMemberDto.setName(name);
        newMemberDto.setRole("ROLE_ADMIN");
        newMemberDto.setUsername(username);
        newMemberDto.setPhone(phone);
        newMemberDto.setRegDate(LocalDateTime.now());
        newMemberDto.setLatestLogDate(LocalDateTime.now());
        newMemberDto.setStatus(0);

        return newMemberDto;
    }

//    public void acceptMember(String username) {
//        MemberEntity member = memberRepository.findByUsername(username);
//        member.setStatus(MemberStatusEnum.ACTIVE.getStatus()); // accept
//        memberRepository.save(member);

//        AcceptLogEntity acceptLog = acceptLogRepository.findByMemberId(memberId);
//        acceptLog.setAcceptStatus(1);
//        acceptLog.setAcceptModifyDate(LocalDateTime.now());
//        acceptLogRepository.save(acceptLog);
//    }

    @Override
    public List<MemberDto> getAllByKidNo(Long kidNo) {
        return memberRepository.findAllByKidNo(kidNo);
    }

    @Override
    public MemberDto getByIdAndKidNo(MemberSearchCondition condition) {
        return memberRepository.findByIdAndKidNo(condition);
    }

    @Override
    public MemberDto findByUsername(String username) {
        return MemberDto.toDto(memberRepository.findByUsername(username));
    }

    @Override  // username으로 멤버가 존재하는지 확인하고, 입력받은 password가 존재하는지 검사
    public boolean checkPassword(String username, String password) {
        MemberEntity member = memberRepository.findByUsername(username);


        if (member == null) {
            return false;
        }

        // 저장된 해시처리한 비밀번호
        String storedPassword = member.getPassword();
        // 입력된 비밀번호와 비교
        boolean isPasswordMatch = bCryptPasswordEncoder.matches(password, storedPassword);

        log.info("Stored password : " + storedPassword);
        log.info("Input password : " + password);
        log.info("Password match: " + isPasswordMatch);

        return isPasswordMatch;
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        MemberEntity member = memberRepository.findByUsername(username);
        if (member != null) {
            log.info("newPassword : " + newPassword);
            log.info("hashed newPassword : " + bCryptPasswordEncoder.encode(newPassword));
            member.setPassword(bCryptPasswordEncoder.encode(newPassword));
            memberRepository.save(member);
        }
    }
}
