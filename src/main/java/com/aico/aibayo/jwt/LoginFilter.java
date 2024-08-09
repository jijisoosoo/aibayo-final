package com.aico.aibayo.jwt;

import com.aico.aibayo.entity.MemberEntity;
import com.aico.aibayo.repository.member.MemberRepository;
import com.aico.aibayo.service.member.TokenService;
import jakarta.servlet.http.Cookie;
import com.aico.aibayo.dto.member.CustomMemberDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;

@Slf4j
@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final TokenService tokenService;
    private final MemberRepository memberRepository;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        CustomMemberDetails customMemberDetails = (CustomMemberDetails) authResult.getPrincipal();
        String username = customMemberDetails.getUsername();
        String role = customMemberDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).findFirst().orElse("ROLE_USER");

        MemberEntity memberEntity = memberRepository.findByUsername(username).orElse(null);
        if (memberEntity != null) {
            memberEntity.setLatestLogDate(LocalDateTime.now());
            log.info("loginfilter setLatestLogDate : {}", LocalDateTime.now());
            memberRepository.save(memberEntity);
        }

        String token = jwtUtil.createJwt(username, role, 86400000L);

        tokenService.saveToken(token);

        Cookie jwtCookie = new Cookie("jwt", token);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(86400);

        response.addCookie(jwtCookie);

        if (role.equals("ROLE_ADMIN") || role.equals("ROLE_PRINCIPAL") || role.equals("ROLE_TEACHER")) {
            response.sendRedirect("/main/admin");
        } else {
            response.sendRedirect("/main/user");
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}