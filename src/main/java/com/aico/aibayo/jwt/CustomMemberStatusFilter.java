package com.aico.aibayo.jwt;

import com.aico.aibayo.common.MemberStatusEnum;
import com.aico.aibayo.entity.MemberEntity;
import com.aico.aibayo.exception.MemberNotFoundException;
import com.aico.aibayo.repository.member.MemberRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class CustomMemberStatusFilter extends OncePerRequestFilter {
    private final MemberRepository memberRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getParameter("username");
        if (username != null) {
            MemberEntity member = memberRepository.findByUsername(username)
                    .orElseThrow(() -> new MemberNotFoundException("username으로 검색한 member 값이 없습니다."));;
            if (member != null && !member.getStatus().equals(MemberStatusEnum.ACTIVE.getStatus())) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "관리자의 승인이 필요합니다.");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
