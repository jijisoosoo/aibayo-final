package com.aico.aibayo.service;

import com.aico.aibayo.dto.MemberDto;
import com.aico.aibayo.repository.member.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public List<MemberDto> getAllByKidNo(Long kidNo) {
        return memberRepository.findAllByKidNo(kidNo);
    }
}
