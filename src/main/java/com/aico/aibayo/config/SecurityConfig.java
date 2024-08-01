package com.aico.aibayo.config;

import com.aico.aibayo.dto.member.CustomOAuth2Member;
import com.aico.aibayo.jwt.CustomLogoutFilter;
import com.aico.aibayo.jwt.JWTFilter;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.jwt.LoginFilter;
import com.aico.aibayo.oauth2.CustomSuccessHandler;
import com.aico.aibayo.service.member.CustomOAuth2MemberService;
import com.aico.aibayo.service.member.TokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import jakarta.servlet.http.Cookie;

import java.io.IOException;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomOAuth2MemberService customOAuth2MemberService;
    private final CustomSuccessHandler customSuccessHandler;
    private final JWTUtil jwtUtil;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final TokenService tokenService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/chat/**", "/inc/**", "/layout/**", "/vendor/**", "/css/**", "/js/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // CSRF 보호 비활성화
        http.csrf(csrf -> csrf.disable());

        // 기본 폼 로그인 비활성화
        http.formLogin(form -> form.disable());

        // HTTP 기본 인증 비활성화
        http.httpBasic(basic -> basic.disable());

        // OAuth2 로그인 설정
        http.oauth2Login(oauth2 -> oauth2
                .loginPage("/member/signIn")
                .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
                        .userService(customOAuth2MemberService))
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
                        CustomOAuth2Member oAuth2Member = (CustomOAuth2Member) authentication.getPrincipal();
                        if (oAuth2Member.isNewMember()) {
                            response.sendRedirect("/register-child"); // 원아정보입력페이지로 리디렉션
                        } else {
                            response.sendRedirect("/main/admin"); // 메인페이지로 리디렉션
                        }
                    }
                }));

        // JWT 검증
        http.addFilterAfter(new JWTFilter(jwtUtil), OAuth2LoginAuthenticationFilter.class);
        http.addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil, tokenService), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new CustomLogoutFilter(jwtUtil, tokenService), UsernamePasswordAuthenticationFilter.class);

        // 커스텀 로그아웃 핸들러 추가
        http.logout(logoutConfigurer -> logoutConfigurer                                       // 로그아웃 기능이 동작
                .logoutUrl("/logout")                           // 로그아웃 처리 URL
                .logoutSuccessUrl("/login")                     // 로그아웃 성공 후 이동 페이지
                .deleteCookies("jwt")     // 로그아웃 후 쿠키 삭제
                .addLogoutHandler(logoutHandler())              // 로그아웃 핸들러
                .logoutSuccessHandler(logoutSuccessHandler()));  // 로그아웃 성공 후 핸들러


        // 경로별 인가 설정
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/member/**", "/", "/login", "/users/login", "/member/**", "/logout", "/css/**", "/images/**", "/js/**").permitAll()
                .requestMatchers("/chat/**", "/inc/**", "/layout/**", "/vendor/**").permitAll()
                .requestMatchers("/main/admin").hasRole("ADMIN")
                .requestMatchers("/main/user").hasRole("USER")
                .anyRequest().authenticated());

        // 세션 관리 설정
        http.sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public LogoutHandler logoutHandler() {
        return (request, response, authentication) -> {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("jwt".equals(cookie.getName())) {
                        String token = cookie.getValue();
                        tokenService.invalidateToken(token); // 토큰 무효화
                        break;
                    }
                }
            }
        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            response.setStatus(HttpServletResponse.SC_OK);
        };
    }
}
