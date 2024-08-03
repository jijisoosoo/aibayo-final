package com.aico.aibayo.control;

import com.aico.aibayo.dto.InviteCodeDto;
import com.aico.aibayo.service.inviteCode.InviteCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/inviteCode")
@RequiredArgsConstructor
public class InviteCodeController {
    private final InviteCodeService inviteCodeService;

    @PostMapping("/mail")
    public ResponseEntity<InviteCodeDto> mail(@RequestBody InviteCodeDto inviteCodeDto) {
        InviteCodeDto saved = inviteCodeService.sendAndInsertInviteCode(inviteCodeDto);
        log.info("mail saved: {}", saved);

        return saved == null ? ResponseEntity.badRequest().build() :
                               ResponseEntity.ok(saved);
    }
}
