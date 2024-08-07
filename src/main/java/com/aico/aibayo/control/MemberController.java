package com.aico.aibayo.control;

import com.aico.aibayo.common.MemberStatusEnum;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.service.member.MemberServiceImpl;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberServiceImpl memberService;
    private final JWTUtil jwtUtil;

    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model) {
        String token = getTokenFromCookies(request.getCookies());
        if (token == null || token.isEmpty()) {
            log.error("JWT token is missing");
            // 여기서 예외를 던지거나, 적절히 처리합니다.
            return;
        }

        String username = jwtUtil.getUsername(token);
        log.info("loginUser: {}", username);
        MemberDto memberDto = memberService.findByUsername(username);

        model.addAttribute("loginInfo", memberDto);
    }

    private String getTokenFromCookies(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwt".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }




    @GetMapping("/signIn")
    public String signIn() {
        return "member/signIn";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "member/signUp";
    }

    @PostMapping("/signUp")
    @ResponseBody
    public String signUpProcess(MemberDto memberDto) {
        MemberDto dto = memberService.signUpProcess(memberDto);

        return "ok";
    }

    @GetMapping("/signUpKid")
    public String signUpKid() {
        return "member/signUpKid";
    }

    @GetMapping("/signInFindPw")
    public String signInFindPw() {
        return "member/signInFindPw";
    }

    @GetMapping("signInResetPw")
    public String singInResetPw() { return "member/signInResetPw"; }

    @GetMapping("/myPage")
    public String myPage() {
        return "member/myPage";
    }



    @PostMapping("/passwordExist")
    public ResponseEntity<Map<String, Boolean>> passwordExist(@RequestBody Map<String, String> request, @ModelAttribute("loginInfo") MemberDto loginInfo) {
        String username = loginInfo.getUsername(); // 토큰에서 가져온 username
        String password = request.get("password");

        log.info("passwordExist / username : " + username);
        log.info("passwordExist / password : " + password);

        boolean passwordExists = memberService.checkPassword(username, password);

        if (passwordExists) {
            System.out.println("passwordExists true");
        } else {
            System.out.println("passwordExists false");
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", passwordExists);


        return ResponseEntity.ok(response);
    }

    @PostMapping("/updatePassword")
    public String updatepassword(@RequestParam("newPassword") String newPassword, @ModelAttribute("loginInfo") MemberDto loginInfo) {
        String username = loginInfo.getUsername();

        log.info("updatePassword / username : " + username);
        log.info("updatePassword / newPassword : " + newPassword);

        memberService.updatePassword(username, newPassword);
//        return "member/myPage";

        if (loginInfo.getRole().equals("ROLE_ADMIN")) {
            return "/admin/main/main";
        } else {
            return "/user/main/main";
        }
    }


}
