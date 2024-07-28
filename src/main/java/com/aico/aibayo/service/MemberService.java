package com.aico.aibayo.service;

import com.aico.aibayo.dto.MemberDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    List<MemberDto> getAllByKidNo(Long kidNo);
}
