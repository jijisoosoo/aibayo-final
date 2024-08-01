package com.aico.aibayo.jwt;

import com.aico.aibayo.service.member.TokenService;
import jakarta.servlet.http.Cookie;
import com.aico.aibayo.dto.member.CustomMemberDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final TokenService tokenService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 클라이언트 요청에서 username, password 추출
        String username = obtainUsername(request);
        String password = obtainPassword(request);

//        System.out.println("attemptAuthentication test username : " + username);

        // spring security에서 username, password를 검증하기 위해서 toekn에 담아야 한다
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        // token에 담은 검증을 위한 AuthenticationManager로 전달
        return authenticationManager.authenticate(authenticationToken);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        CustomMemberDetails customMemberDetails = (CustomMemberDetails) authResult.getPrincipal();

        String username = customMemberDetails.getUsername();

        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        String role = authorities.stream().map(GrantedAuthority::getAuthority).findFirst().orElse("ROLE_ADMIN");

        System.out.println("loginfilter role : " + role);

        String token = jwtUtil.createJwt(username, role, 60 * 60 * 10L);
//        response.addHeader("Authorization", "Bearer " + token);

        // JWT를 서버에 저장
        tokenService.saveToken(token);

        // JWT를 쿠키에 설정
        Cookie jwtCookie = new Cookie("jwt", token);
        jwtCookie.setHttpOnly(true);
//        jwtCookie.setSecure(true); // HTTPS를 사용하는 경우 설정
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(60 * 60 * 10); // 쿠키 유효 시간 설정 (초 단위)


        response.addCookie(jwtCookie);

        if (role.equals("ROLE_ADMIN") || role.equals("ROLE_PRINCIPAL") || role.equals("ROLE_TEACHER")) {
            response.sendRedirect("/main/admin");
        } else if (role.equals("ROLE_USER")) {
            response.sendRedirect("/main/user");
        }

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(401);
    }
}