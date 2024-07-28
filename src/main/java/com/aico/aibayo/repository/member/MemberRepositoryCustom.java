package com.aico.aibayo.repository.member;

import com.aico.aibayo.dto.MemberDto;
import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberDto> findAllByKidNo(Long kidNo);
}
