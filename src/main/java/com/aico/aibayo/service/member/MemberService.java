package com.aico.aibayo.service.member;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.MemberSearchCondition;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    List<MemberDto> getAllByKidNo(Long kidNo);
    MemberDto getByIdAndKidNo(MemberSearchCondition condition);
    MemberDto findByUsername(String username);
    MemberDto getByUsernameWithParentKid(String username);
}
