package com.aico.aibayo.control;


import com.aico.aibayo.dto.member.CustomMemberDetails;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.service.member.CustomMemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final CustomMemberDetailService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomMemberDetails customMemberDetails, HttpServletResponse response) {
        try {
            // 사용자 인증
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            customMemberDetails.getUsername(),
                            customMemberDetails.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // JWT 토큰 생성
            String token = jwtUtil.createJwt(authentication.getName(), authentication.getAuthorities().iterator().next().getAuthority(), 86400000L); // 24시간 유효

            // HTTP-Only 쿠키 설정
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(true); // HTTPS에서만 쿠키 전송
            cookie.setPath("/");
            cookie.setMaxAge(3600); // 1시간 유효

            response.addCookie(cookie);
return ResponseEntity.ok("로그인 성공");

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패: " + e.getMessage());
        }
     }
}
