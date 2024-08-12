package com.aico.aibayo.repository.member;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.MemberSearchCondition;
import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberDto> findAllByKidNo(Long kidNo);
    MemberDto findByIdAndKidNo(MemberSearchCondition condition);
    MemberDto findByUsernameWithParentKid(String username);
    MemberDto findDtoById(Long id);
}
