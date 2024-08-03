package com.aico.aibayo.service.inviteCode;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.AcceptTypeEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.common.InviteTypeEnum;
import com.aico.aibayo.dto.InviteCodeDto;
import com.aico.aibayo.entity.AcceptLogEntity;
import com.aico.aibayo.entity.InviteCodeEntity;
import com.aico.aibayo.repository.AcceptLogRepository;
import com.aico.aibayo.repository.InviteCodeRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Slf4j
@Service
@RequiredArgsConstructor
public class InviteCodeServiceImpl implements InviteCodeService {
    private final InviteCodeRepository inviteCodeRepository;
    private final AcceptLogRepository acceptLogRepository;
    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine springTemplateEngine;

    @Override
    @Transactional
    public InviteCodeDto sendAndInsertInviteCode(InviteCodeDto inviteCodeDto) {
        sendEmail(inviteCodeDto);

        return insertInviteCode(inviteCodeDto);
    }

    private void sendEmail(InviteCodeDto inviteCodeDto) {
        inviteCodeDto.setVerifyCode(createCode()); // 인증번호 생성
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        String desc = InviteTypeEnum.findByType(inviteCodeDto.getInviteType())
                                    .getDesc();
        // 추후 aibayo에 유치원명 들어가도록 변경
        String subject = "[aibayo]초대 메일이 도착했습니다. (" + desc + ")";

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setTo(inviteCodeDto.getInviteEmail()); // 메일 수신자
            mimeMessageHelper.setSubject(subject); // 메일 제목
            mimeMessageHelper.setText(setContext(inviteCodeDto.getVerifyCode()), true);  // 메일 본문, HTML 여부
            mimeMessageHelper.setFrom(new InternetAddress("admin@aico.co.kr", "aibayo"));
            javaMailSender.send(mimeMessage); // 메일 발송
            log.info(" SEND MAIL SUCCESS >>>>>>>>>>>>>>>>>>>>>>>>>> ");
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private String setContext(String verifyCode) {
        Context context = new Context();
        context.setVariable("verifyCode", verifyCode);
        return springTemplateEngine.process("/admin/inviteCode/email", context);
    }

    private String createCode() {
        return UUID.randomUUID().toString();
    }

    private InviteCodeDto insertInviteCode(InviteCodeDto inviteCodeDto) {
        AcceptLogEntity acceptLogEntity = AcceptLogEntity.builder()
                .acceptType(AcceptTypeEnum.INVITE_CODE.getType())
                .acceptStatus(AcceptStatusEnum.ACCEPT.getStatus())
                .acceptDate(LocalDateTime.now())
                .acceptRegDate(LocalDateTime.now())
                .build();
        AcceptLogEntity savedAcceptLog =
                acceptLogRepository.save(acceptLogEntity);

        InviteCodeEntity inviteCodeEntity = InviteCodeEntity.builder()
                .acceptNo(savedAcceptLog.getAcceptNo())
                .verifyCode(inviteCodeDto.getVerifyCode())
                .inviteType(inviteCodeDto.getInviteType())
                .inviteEmail(inviteCodeDto.getInviteEmail())
                .inviteRegDate(LocalDate.now())
                .inviteExpireDate(LocalDate.now().plusDays(7))
                .inviteExpireFlag(BooleanEnum.FALSE.getBool())
                .kinderNo(inviteCodeDto.getKinderNo())
                .kidNo(inviteCodeDto.getKidNo())
                .build();
        InviteCodeEntity savedInviteCode =
                inviteCodeRepository.save(inviteCodeEntity);

        return InviteCodeDto.toDto(savedInviteCode);
    }
}
