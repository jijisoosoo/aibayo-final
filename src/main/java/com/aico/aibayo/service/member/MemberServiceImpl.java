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
import com.aico.aibayo.repository.RegisterKinderRepository;
import com.aico.aibayo.repository.TeacherKinderRepository;
import com.aico.aibayo.repository.classKid.ClassKidRepository;
import com.aico.aibayo.repository.ParentKidRepository;
import com.aico.aibayo.repository.kid.KidRepository;
import com.aico.aibayo.repository.member.MemberRepository;
import groovy.util.logging.Slf4j;
import jakarta.persistence.EntityNotFoundException;
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
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;
    private final KidRepository kidRepository;
    private final ParentKidRepository parentKidRepository;
    private final ClassKidRepository classKidRepository;
    private final AcceptLogRepository acceptLogRepository;
    private final TeacherKinderRepository teacherKinderRepository;
    private final RegisterKinderRepository registerKinderRepository;


    @Transactional
    public void signUpProcess(MemberDto memberDto) {
        String username = memberDto.getUsername();
        log.info("signUpProcess / username = {}", username);

        if (memberRepository.existsByUsername(username)) {
            log.warn("회원가입 실패: 이미 존재하는 이메일 = {}", username);
            return;
        }

        MemberEntity memberEntity = createMemberEntity(memberDto);
        MemberEntity newMemberEntity = memberRepository.save(memberEntity);
        log.info("회원 정보 저장 완료: username = {}", username);

        if (memberDto.getRole().equals("ROLE_USER")) {
            processParentSignUp(memberDto, newMemberEntity);
        } else {
            processTeacherSignUp(memberDto, newMemberEntity);
        }
    }

    private MemberEntity createMemberEntity(MemberDto memberDto) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername(memberDto.getUsername());
        memberEntity.setName(memberDto.getName());
        memberEntity.setRole(memberDto.getRole());
        memberEntity.setRoleNo(memberDto.getRoleNo());
        memberEntity.setPassword(bCryptPasswordEncoder.encode(memberDto.getPassword()));
        memberEntity.setPhone(memberDto.getPhone());
        memberEntity.setRegDate(LocalDateTime.now());
        memberEntity.setLatestLogDate(LocalDateTime.now());
        memberEntity.setStatus(memberDto.getStatus());
        memberEntity.setKinderNo(memberDto.getKinderNo());
        return memberEntity;
    }

    private void processParentSignUp(MemberDto memberDto, MemberEntity newMemberEntity) {
        KidEntity checkKid = findOrCreateKid(memberDto);
        log.info("아이 정보 확인 완료: kidNo = {}", checkKid.getKidNo());

        if (memberDto.getInviteId() == null) {
            if (classKidRepository.findAllByClassNoAndKidNo(memberDto.getClassNo(), checkKid.getKidNo()).isEmpty()) {
                AcceptLogEntity acceptLogEntity = createAcceptLog(AcceptTypeEnum.CLASS_KID, AcceptStatusEnum.WAIT);
                ClassKidEntity classKidEntity = new ClassKidEntity();
                classKidEntity.setClassNo(memberDto.getClassNo());
                classKidEntity.setKidNo(checkKid.getKidNo());
                classKidEntity.setAcceptNo(acceptLogEntity.getAcceptNo());
                classKidRepository.save(classKidEntity);
                log.info("classKid 정보 저장: classNo = {}, kidNo = {}", memberDto.getClassNo(), checkKid.getKidNo());
            }

            Long memberAcceptNo = createAcceptLogForParent(memberDto);
            ParentKidEntity parentKidEntity = new ParentKidEntity();
            parentKidEntity.setId(newMemberEntity.getId());
            parentKidEntity.setKidNo(checkKid.getKidNo());
            parentKidEntity.setAcceptNo(memberAcceptNo);
            parentKidEntity.setIsMainParent(BooleanEnum.FALSE.getBool());
            parentKidEntity.setParentRelationship(memberDto.getRelationship());
            parentKidRepository.save(parentKidEntity);
            log.info("parentKid 정보 저장 완료: memberId = {}, kidNo = {}", newMemberEntity.getId(), checkKid.getKidNo());
        }

        Long memberAcceptNo = createAcceptLogForParent(memberDto);
        ParentKidEntity parentKidEntity = new ParentKidEntity();
        parentKidEntity.setId(newMemberEntity.getId());
        parentKidEntity.setKidNo(checkKid.getKidNo());
        parentKidEntity.setAcceptNo(memberAcceptNo);
        parentKidEntity.setIsMainParent(BooleanEnum.TRUE.getBool());
        parentKidEntity.setParentRelationship(memberDto.getRelationship());
        parentKidRepository.save(parentKidEntity);
        log.info("parentKid 정보 저장 완료: memberId = {}, kidNo = {}", newMemberEntity.getId(), checkKid.getKidNo());

    }

    private KidEntity findOrCreateKid(MemberDto memberDto) {
        return kidRepository.findByKinderNoAndKidNameAndKidBirthAndKidGenderAndDischargeFlag(
                memberDto.getKinderNo(), memberDto.getKidName(), memberDto.getKidBirth(),
                Integer.valueOf(memberDto.getKidGender()), BooleanEnum.FALSE.getBool()
        ).orElseGet(() -> {
            KidEntity kidEntity = new KidEntity();
            kidEntity.setKinderNo(memberDto.getKinderNo());
            kidEntity.setKidName(memberDto.getKidName());
            kidEntity.setKidBirth(memberDto.getKidBirth());
            kidEntity.setKidGender(Integer.valueOf(memberDto.getKidGender()));
            kidEntity.setAdmissionDate(LocalDateTime.now());
            log.info("새 아이 정보 저장: {}", kidEntity);
            return kidRepository.save(kidEntity);
        });
    }

    private Long createAcceptLogForParent(MemberDto memberDto) {
        AcceptStatusEnum status = memberDto.getInviteId() == null ? AcceptStatusEnum.WAIT : AcceptStatusEnum.ACCEPT;
        AcceptLogEntity acceptLogEntity = createAcceptLog(AcceptTypeEnum.PARENT_KID, status);
        return acceptLogEntity.getAcceptNo();
    }

    private AcceptLogEntity createAcceptLog(AcceptTypeEnum type, AcceptStatusEnum status) {
        AcceptLogEntity acceptLogEntity = new AcceptLogEntity();
        acceptLogEntity.setAcceptType(type.getType());
        acceptLogEntity.setAcceptStatus(status.getStatus());
        acceptLogEntity.setAcceptRegDate(LocalDateTime.now());
        acceptLogEntity.setAcceptDeleteFlag(BooleanEnum.FALSE.getBool());
        if (status == AcceptStatusEnum.ACCEPT) {
            acceptLogEntity.setAcceptDate(LocalDateTime.now());
        }
        return acceptLogRepository.save(acceptLogEntity);
    }

    private void processTeacherSignUp(MemberDto memberDto, MemberEntity newMemberEntity) {
        Long memberAcceptNo = createAcceptLogForParent(memberDto);
        TeacherKinderEntity teacherKinderEntity = new TeacherKinderEntity();
        teacherKinderEntity.setTeacherId(newMemberEntity.getId());
        teacherKinderEntity.setKinderNo(memberDto.getKinderNo());
        teacherKinderEntity.setAcceptNo(memberAcceptNo);
        teacherKinderRepository.save(teacherKinderEntity);
        log.info("교사-유치원 정보 저장 완료: teacherId = {}, kinderNo = {}", newMemberEntity.getId(), memberDto.getKinderNo());
    }



    @Override
    public List<MemberDto> getAllByKidNo(Long kidNo) {
        return memberRepository.findAllByKidNo(kidNo);
    }

    @Override
    public MemberDto getByIdAndKidNo(MemberSearchCondition condition) {
        return memberRepository.findByIdAndKidNo(condition).orElse(null);
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
        return memberRepository.findByUsernameWithParentKid(username).orElse(null);
    }

    @Override
    public MemberDto getByUsernameWithParentKid(MemberSearchCondition condition) {
        return memberRepository.findByUsernameWithParentKid(condition).orElse(null);
    }

    // 계정 삭제
    // ROLE_USER : PARENT_KID 엔티티와 엮어서 ACCEPT_LOG 가져와서 MEMBER와 같이 상태값 변경
    // ROLE_TEACHER : CLASS_TEACHER 엔티티와 엮어서 ACCEPT_LOG 가져와서 MEMBER와 같이 상태값 변경

    @Override
    public void deleteMember(String username, String role) {
        if (role.equals("ROLE_USER")) {
            System.out.println("hi user");

            MemberDto memberDto = memberRepository.findByUsernameWithParentKid(username).orElse(null);
            MemberEntity memberEntity = memberRepository.findByUsername(memberDto.getUsername()).orElse(null);
            AcceptLogEntity acceptLogEntity = acceptLogRepository.findByAcceptNo(memberDto.getAcceptNo()).orElse(null);
//            log.info("deleteMember / memberEntity.getStatus : {} / memberEneity.getInactivateDate : {} / acceptLogEntity.getAcceptStatus : {} / acceptLogEntity.getAcceptDeleteFlag : {} / acceptLogEntity.acceptDeleteDate : {] ", memberEntity.getStatus(), memberEntity.getInactivateDate(), acceptLogEntity.getAcceptStatus(), acceptLogEntity.getAcceptDeleteFlag(), acceptLogEntity.getAcceptDeleteDate());
            memberEntity.setStatus(MemberStatusEnum.INACTIVE.getStatus());
            memberEntity.setInactivateDate(LocalDateTime.now());
            memberRepository.save(memberEntity);
            acceptLogEntity.setAcceptStatus(AcceptStatusEnum.DELETE.getStatus());
            acceptLogEntity.setAcceptDeleteFlag(BooleanEnum.TRUE.getBool());
            acceptLogEntity.setAcceptDeleteDate(LocalDateTime.now());
            acceptLogRepository.save(acceptLogEntity);
//            log.info("deleteMember / memberEntity.getStatus : {} / memberEneity.getInactivateDate : {} / acceptLogEntity.getAcceptStatus : {} / acceptLogEntity.getAcceptDeleteFlag : {} / acceptLogEntity.acceptDeleteDate : {] ", memberEntity.getStatus(), memberEntity.getInactivateDate(), acceptLogEntity.getAcceptStatus(), acceptLogEntity.getAcceptDeleteFlag(), acceptLogEntity.getAcceptDeleteDate());
        } else {
            System.out.println("hi admin");

            MemberDto memberDto = memberRepository.findByUsernameWithClassTeacher(username).orElse(null);
            MemberEntity memberEntity = memberRepository.findByUsername(memberDto.getUsername()).orElse(null);
            AcceptLogEntity acceptLogEntity = acceptLogRepository.findByAcceptNo(memberDto.getAcceptNo()).orElse(null);

            System.out.println("hiadmin username" + memberEntity.getUsername());
            System.out.println("hiadmin acceptstatus" + acceptLogEntity.getAcceptStatus());

            memberEntity.setStatus(MemberStatusEnum.INACTIVE.getStatus());
            memberEntity.setInactivateDate(LocalDateTime.now());
            memberRepository.save(memberEntity);
            acceptLogEntity.setAcceptStatus(AcceptStatusEnum.DELETE.getStatus());
            acceptLogEntity.setAcceptDeleteFlag(BooleanEnum.TRUE.getBool());
            acceptLogEntity.setAcceptDeleteDate(LocalDateTime.now());
            acceptLogRepository.save(acceptLogEntity);
        }
    }
}
