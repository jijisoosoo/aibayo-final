package com.aico.aibayo.service.member;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.AcceptTypeEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.common.MemberStatusEnum;
import com.aico.aibayo.dto.classKid.ClassKidDto;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.MemberSearchCondition;
import com.aico.aibayo.entity.*;
import com.aico.aibayo.exception.MemberNotFoundException;
import com.aico.aibayo.repository.AcceptLogRepository;
import com.aico.aibayo.repository.classKid.ClassKidRepository;
import com.aico.aibayo.repository.ParentKidRepository;
import com.aico.aibayo.repository.kid.KidRepository;
import com.aico.aibayo.repository.member.MemberRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
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
        String username = memberDto.getUsername();
        log.info("회원가입 진행: username = {}", username);

        Boolean isExist = memberRepository.existsByUsername(username);
        if (isExist) {
            log.warn("회원가입 실패: 이미 존재하는 이메일 = {}", username);
            return;
        }

        try {
            MemberEntity memberEntity = new MemberEntity();
            memberEntity.setUsername(memberDto.getUsername());
            memberEntity.setName(memberDto.getName());
            memberEntity.setRole(memberDto.getRole());
            memberEntity.setPassword(bCryptPasswordEncoder.encode(memberDto.getPassword()));
            memberEntity.setPhone(memberDto.getPhone());
            memberEntity.setRegDate(LocalDateTime.now());
            memberEntity.setLatestLogDate(LocalDateTime.now());
            memberEntity.setStatus(MemberStatusEnum.TEMP.getStatus());
            MemberEntity newMemberEntity = memberRepository.save(memberEntity);
            log.info("회원 정보 저장 완료: username = {}", username);

            Long checkKinderNo = memberDto.getKinderNo();
            String checkKidName = memberDto.getKidName();
            LocalDate checkKidBirth = memberDto.getKidBirth();
            Integer checkKidGender = Integer.valueOf(memberDto.getKidGender());

            log.info("아이 정보 확인: kinderNo = {}, kidName = {}, kidBirth = {}, kidGender = {}", checkKinderNo, checkKidName, checkKidBirth, checkKidGender);
            KidEntity checkKid = kidRepository.findByKinderNoAndKidNameAndKidBirthAndKidGenderAndDischargeFlag(checkKinderNo, checkKidName, checkKidBirth, checkKidGender, BooleanEnum.FALSE.getBool())
                    .orElseGet(() -> {
                        KidEntity kidEntity = new KidEntity();
                        kidEntity.setKinderNo(memberDto.getKinderNo());
                        kidEntity.setKidName(memberDto.getKidName());
                        kidEntity.setKidBirth(memberDto.getKidBirth());
                        kidEntity.setKidGender(Integer.valueOf(memberDto.getKidGender()));
                        kidEntity.setAdmissionDate(LocalDateTime.now());
                        log.info("새 아이 정보 저장: {}", kidEntity);
                        return kidRepository.save(kidEntity);
                    });

            log.info("아이 정보 확인 완료: kidNo = {}", checkKid.getKidNo());

            List<ClassKidDto> allByClassNoAndKidNo = classKidRepository.findAllByClassNoAndKidNo(memberDto.getClassNo(), checkKid.getKidNo());
            if (allByClassNoAndKidNo.isEmpty()) {
                AcceptLogEntity kidAcceptLogEntity = new AcceptLogEntity();
                kidAcceptLogEntity.setAcceptType(AcceptTypeEnum.CLASS_KID.getType());
                kidAcceptLogEntity.setAcceptStatus(AcceptStatusEnum.WAIT.getStatus());
                kidAcceptLogEntity.setAcceptRegDate(LocalDateTime.now());
                kidAcceptLogEntity.setAcceptDeleteFlag(BooleanEnum.FALSE.getBool());
                AcceptLogEntity acceptLogEntity = acceptLogRepository.save(kidAcceptLogEntity);
                log.info("아이 수락 로그 저장: {}", acceptLogEntity);

                ClassKidEntity classKidEntity = new ClassKidEntity();
                classKidEntity.setClassNo(memberDto.getClassNo());
                classKidEntity.setKidNo(checkKid.getKidNo());
                classKidEntity.setAcceptNo(acceptLogEntity.getAcceptNo());
                classKidRepository.save(classKidEntity);
                log.info("클래스-아이 정보 저장: classNo = {}, kidNo = {}", memberDto.getClassNo(), checkKid.getKidNo());
            }

            Long memberAcceptNo = 0L;
            if (memberDto.getInvite() == null) {
                AcceptLogEntity acceptLogEntity = new AcceptLogEntity();
                acceptLogEntity.setAcceptType(AcceptTypeEnum.PARENT_KID.getType());
                acceptLogEntity.setAcceptStatus(AcceptStatusEnum.WAIT.getStatus());
                acceptLogEntity.setAcceptRegDate(LocalDateTime.now());
                acceptLogEntity.setAcceptDeleteFlag(BooleanEnum.FALSE.getBool());
                AcceptLogEntity saveAcceptLogEntity = acceptLogRepository.save(acceptLogEntity);
                memberAcceptNo = saveAcceptLogEntity.getAcceptNo();
                log.info("부모-아이 수락 로그 저장: {}", saveAcceptLogEntity);
            } else {
                AcceptLogEntity acceptLogEntity = new AcceptLogEntity();
                acceptLogEntity.setAcceptType(AcceptTypeEnum.PARENT_KID.getType());
                acceptLogEntity.setAcceptStatus(AcceptStatusEnum.ACCEPT.getStatus());
                acceptLogEntity.setAcceptDate(LocalDateTime.now());
                acceptLogEntity.setAcceptRegDate(LocalDateTime.now());
                acceptLogEntity.setAcceptDeleteFlag(BooleanEnum.FALSE.getBool());
                AcceptLogEntity saveAcceptLogEntity = acceptLogRepository.save(acceptLogEntity);
                memberAcceptNo = saveAcceptLogEntity.getAcceptNo();
                log.info("부모-아이 수락 로그 저장 (초대): {}", saveAcceptLogEntity);
            }

            ParentKidEntity parentKidEntity = new ParentKidEntity();
            parentKidEntity.setId(newMemberEntity.getId());
            parentKidEntity.setKidNo(checkKid.getKidNo());
            parentKidEntity.setAcceptNo(memberAcceptNo);
            parentKidEntity.setIsMainParent(BooleanEnum.FALSE.getBool());
            parentKidEntity.setParentRelationship(memberDto.getRelationship());
            parentKidRepository.save(parentKidEntity);
            log.info("부모-아이 정보 저장 완료: memberId = {}, kidNo = {}", newMemberEntity.getId(), checkKid.getKidNo());
        } catch (Exception e) {
            log.error("회원가입 처리 중 오류 발생: {}", e.getMessage(), e);
            throw e;
        }
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
                .orElseThrow(() -> new MemberNotFoundException("username으로 검색한 member 값이 없습니다."));
        ;

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
                .orElseThrow(() -> new MemberNotFoundException("username으로 검색한 member 값이 없습니다."));
        ;
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
