package com.aico.aibayo.service.inviteCode;

import com.aico.aibayo.dto.InviteCodeDto;
import org.springframework.stereotype.Service;

@Service
public interface InviteCodeService {
    InviteCodeDto sendAndInsertInviteCode(InviteCodeDto inviteCodeDto);
}
