package com.aico.aibayo.service.member;

import com.aico.aibayo.dto.member.*;
import com.aico.aibayo.entity.MemberEntity;
import com.aico.aibayo.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2MemberService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;

    // OAuth2 사용자 정보 로드
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 부모 클래스의 loadUser 메서드를 호출하여 사용자 정보를 가져옵니다.
        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println("OAuth2User : " + oAuth2User);

        // OAuth2 Provider ID 가져오기
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;

        if (registrationId.equals("naver")) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        } else if (registrationId.equals("google")) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        } else {
            return null;
        }

        // 리소스 서버에서 받은 정보로 사용자 이름을 생성
        String username = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId();

        // 데이터베이스에서 해당 사용자 정보를 조회합니다.
        MemberEntity existData = memberRepository.findByUsername(username);
        if (existData == null) {
            // 사용자 정보가 없으면 새 사용자 정보를 생성합니다.
            MemberEntity memberEntity = new MemberEntity();
            memberEntity.setUsername(username);
            memberEntity.setName(oAuth2Response.getName());
            memberEntity.setRole("ROLE_ADMIN");
            memberRepository.save(memberEntity); // 엔티티를 데이터베이스에 저장

            MemberDto memberDto = new MemberDto();
            memberDto.setName(oAuth2Response.getName());
            memberDto.setUsername(username);
            memberDto.setRole("ROLE_ADMIN");
            return new CustomOAuth2Member(memberDto); // 다른 클래스에서 사용하기 위해 DTO를 반환
        } else {
            // 사용자 정보가 있으면 기존 정보를 업데이트합니다.
            existData.setName(oAuth2Response.getName());
            memberRepository.save(existData);

            MemberDto memberDto = new MemberDto();
            memberDto.setName(oAuth2Response.getName());
            memberDto.setUsername(username);
            memberDto.setRole("ROLE_ADMIN");
            return new CustomOAuth2Member(memberDto);
        }
    }
}
