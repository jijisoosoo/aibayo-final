package com.aico.aibayo.jwt;

import com.aico.aibayo.dto.member.CustomMemberDetails;
import com.aico.aibayo.entity.MemberEntity;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.http.Cookie;


import java.io.IOException;

@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private final JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // request에서 쿠키를 찾음
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("jwt")) {
                token = cookie.getValue();
            }
        }

        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // 토큰 소멸 시간 검증
        if (jwtUtil.isExpired(token)) {
            System.out.println("token expired");
            filterChain.doFilter(request, response);
            return;
        }
        // token에서 username, role 획득
        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        // userEntity를 생성하면 값 세팅
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername(username);
        memberEntity.setPassword("temppassword");
        memberEntity.setRole(role);

        // userDetails에 회원 정보 객체 담기
        CustomMemberDetails customMemberDetails = new CustomMemberDetails(memberEntity);

        // spring security 인증 토큰 생성
        Authentication authToken = new UsernamePasswordAuthenticationToken(customMemberDetails, null, customMemberDetails.getAuthorities());

        // 세션에 사용자 등록
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }
}