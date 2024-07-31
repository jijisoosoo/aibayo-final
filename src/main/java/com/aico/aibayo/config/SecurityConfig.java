package com.aico.aibayo.config;

import com.aico.aibayo.jwt.CustomLogoutFilter;
import com.aico.aibayo.jwt.JWTFilter;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.jwt.LoginFilter;
import com.aico.aibayo.oauth2.CustomSuccessHandler;
import com.aico.aibayo.service.member.CustomOAuth2MemberService;
import com.aico.aibayo.service.member.TokenService;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;

@Configuration // 이 클래스가 설정 클래스임을 나타냄
@EnableWebSecurity // 웹 보안을 활성화
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 생성
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

    @Bean // BCryptPasswordEncoder 빈 생성, 비밀번호 암호화에 사용
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/chat/**", "/inc/**", "/layout/**", "/vendor/**");
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
                .successHandler(customSuccessHandler));

        // JWT 검증
        http.addFilterAfter(new JWTFilter(jwtUtil), OAuth2LoginAuthenticationFilter.class);
        http.addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil, tokenService), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new CustomLogoutFilter(jwtUtil, tokenService), UsernamePasswordAuthenticationFilter.class);

        // 경로별 인가 설정
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/member/**", "/", "/login", "/logout", "/css/**", "/images/**", "/js/**").permitAll() // 로그인, 홈, 회원가입, CSS, 이미지, JS, 인클루드, 벤더, 채팅 경로는 모든 사용자에게 허용
                .requestMatchers("/chat/**", "/inc/**", "/layout/**", "/vendor/**").permitAll()
                .requestMatchers("/main/admin").hasRole("ADMIN")
                .requestMatchers("/main/user").hasRole("USER")
                .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
        );

        // 세션 관리 설정
        http.sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // 세션을 사용하지 않음 (무상태)

        return http.build(); // 설정된 SecurityFilterChain을 빌드하여 반환
    }
}
