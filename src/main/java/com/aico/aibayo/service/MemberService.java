package com.aico.aibayo.service;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.MemberSearchCondition;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    List<MemberDto> getAllByKidNo(Long kidNo);
    MemberDto getByIdAndKidNo(MemberSearchCondition condition);
}
