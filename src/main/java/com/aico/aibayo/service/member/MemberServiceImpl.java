package com.aico.aibayo.service.member;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.AcceptTypeEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.common.MemberStatusEnum;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.MemberSearchCondition;
import com.aico.aibayo.entity.AcceptLogEntity;
import com.aico.aibayo.entity.KidEntity;
import com.aico.aibayo.entity.MemberEntity;
import com.aico.aibayo.entity.ParentKidEntity;
import com.aico.aibayo.exception.MemberNotFoundException;
import com.aico.aibayo.repository.AcceptLogRepository;
import com.aico.aibayo.repository.ClassKidRepository;
import com.aico.aibayo.repository.ParentKidRepository;
import com.aico.aibayo.repository.kid.KidRepository;
import com.aico.aibayo.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
    private final MemberRepository memberRepository;
    private final KidRepository kidRepository;
    private final ParentKidRepository parentKidRepository;
    private final ClassKidRepository classKidRepository;
    private final AcceptLogRepository acceptLogRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void signUpProcessUser(MemberDto memberDto) {  // 일반 로그인 (초대X)

        String username = memberDto.getUsername(); // email
        Boolean isExist = memberRepository.existsByUsername(username); // email이 있으면
        if (isExist) { // 이미 존재하는 이메일이 있으면 종료 (회원가입 실패)
            return;
        }

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername(memberDto.getUsername());
        memberEntity.setName(memberDto.getName());
        memberEntity.setRole(memberDto.getRole());
        memberEntity.setPassword(bCryptPasswordEncoder.encode(memberDto.getPassword()));
        memberEntity.setPhone(memberDto.getPhone());
        memberEntity.setRegDate(LocalDateTime.now());
        memberEntity.setLatestLogDate(LocalDateTime.now());
        memberEntity.setStatus(MemberStatusEnum.TEMP.getStatus()); // wait
        MemberEntity newMemberEntity = memberRepository.save(memberEntity);


        Long checkKinderNo = memberDto.getKinderNo();
        String checkKidName = memberDto.getKidName();
        LocalDate checkKidBirth = memberDto.getKidBirth();
        Integer checkKidGender = Integer.valueOf(memberDto.getKidGender());

        // kidEntity
        KidEntity checkKid = kidRepository.
                findByKinderNoAndkAndKidNameAndkAndKidBirthAndkAndKidGenderAnAndDischargeFlag(checkKinderNo, checkKidName, checkKidBirth, checkKidGender, BooleanEnum.FALSE.getBool()).orElseGet(
                        () -> {
                            KidEntity kidEntity = new KidEntity();
                            kidEntity.setKinderNo(memberDto.getKinderNo());
                            kidEntity.setKidName(memberDto.getKidName());
                            kidEntity.setKidBirth(memberDto.getKidBirth());
                            kidEntity.setKidGender(Integer.valueOf(memberDto.getKidGender()));
                            kidEntity.setAdmissionDate(LocalDateTime.now());
                            return kidRepository.save(kidEntity);
                        }
                );

        checkKid.getKidNo();

        // kid accept log
        // checkKid의 kidNo, MemberDto의 classNo를 가진 classKidEntity의 레코드의 accept_no
        // 아래 조건까지 통과하는 accept_no가 있는지,
        // 해당 accept_no가 있는 레코드이 accept_status가 1인게 있는지
        // 있으면 넘어가고, 없으면 acceptLog insert -> classKid insert

        // ClassKidEntity (필요없어짐. 회원가입할 때 원아는 insert가 아니라 그냥 선택함)


        // AcceptLogEntity(parent_kid)
        Long acceptNo = 0L;
        if (memberDto.getInvite() == null) {
            AcceptLogEntity acceptLogEntity = new AcceptLogEntity();
            acceptLogEntity.setAcceptType(AcceptTypeEnum.PARENT_KID.getType());
            acceptLogEntity.setAcceptStatus(AcceptStatusEnum.WAIT.getStatus());
            acceptLogEntity.setAcceptRegDate(LocalDateTime.now());
            AcceptLogEntity saveAcceptLogEntity = acceptLogRepository.save(acceptLogEntity);
            acceptNo = saveAcceptLogEntity.getAcceptNo();
        } else {
            AcceptLogEntity acceptLogEntity = new AcceptLogEntity();
            acceptLogEntity.setAcceptType(AcceptTypeEnum.PARENT_KID.getType());
            acceptLogEntity.setAcceptStatus(AcceptStatusEnum.ACCEPT.getStatus());
            acceptLogEntity.setAcceptDate(LocalDateTime.now());
            acceptLogEntity.setAcceptRegDate(LocalDateTime.now());
            acceptLogEntity.setAcceptDeleteFlag(BooleanEnum.FALSE.getBool());
            AcceptLogEntity saveAcceptLogEntity = acceptLogRepository.save(acceptLogEntity);
            acceptNo = saveAcceptLogEntity.getAcceptNo();
        }



        // ParentKidEntity (is_main은 초대코드 유무 상관없이 일단 false)
        ParentKidEntity parentKidEntity = new ParentKidEntity();
        parentKidEntity.setId(newMemberEntity.getId());
        parentKidEntity.setKidNo(checkKid.getKidNo());
        parentKidEntity.setAcceptNo(acceptNo);
        parentKidEntity.setIsMainParent(BooleanEnum.FALSE.getBool());
        parentKidEntity.setParentRelationship(memberDto.getRelationship());




    }

    public void signUpProcessUserInvite(MemberDto memberDto) {  // 일반 로그인 초대코드 버전

    }

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
        return MemberDto.toDto(memberRepository.findByUsername(username)
                .orElseThrow(() -> new MemberNotFoundException("username으로 검색한 member 값이 없습니다.")));
    }

    @Override  // username으로 멤버가 존재하는지 확인하고, 입력받은 password가 존재하는지 검사
    public boolean checkPassword(String username, String password) {
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new MemberNotFoundException("username으로 검색한 member 값이 없습니다."));;


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
        MemberEntity member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new MemberNotFoundException("username으로 검색한 member 값이 없습니다."));;
        if (member != null) {
            log.info("newPassword : " + newPassword);
            log.info("hashed newPassword : " + bCryptPasswordEncoder.encode(newPassword));
            member.setPassword(bCryptPasswordEncoder.encode(newPassword));
            memberRepository.save(member);
        }
    }

    @Override
    public MemberDto getByUsernameWithParentKid(String username) {
        return memberRepository.findByUsernameWithParentKid(username);
    }
}
