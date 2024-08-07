package com.aico.aibayo.control;

import com.aico.aibayo.dto.SignUpFinalFormDto;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.SignUpFormDto;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.service.member.MemberServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;



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
    public String signUpKidForm(HttpSession session, Model model) {
        SignUpFormDto form = (SignUpFormDto) session.getAttribute("form");
        model.addAttribute("form", form);
        return "member/signUpKid";
    }

    @PostMapping("/signUpKid")
    @ResponseBody
    public String signUpKid(@RequestBody SignUpFormDto form, HttpSession session) {
        // 세션에 데이터를 저장하거나 다른 방법으로 저장할 수 있습니다.
        // 여기서는 간단하게 모델에 추가하겠습니다.
        session.setAttribute("form", form);

        System.out.println("form.getUsername : " + form.getUsername());
        System.out.println("form.getPassword : " + form.getPassword());
        System.out.println("form.getRole : " + form.getRole());
        return "success";
    }

    @PostMapping("/signUpKinder")
    @ResponseBody
    public String signUpKinder(@RequestBody SignUpFormDto form) {
        // 세션에 데이터를 저장하거나 다른 방법으로 저장할 수 있습니다.
        // 여기서는 간단하게 모델에 추가하겠습니다.
        return "success";
    }


    @PostMapping("/finalSignUp")
    public String finalSignUp(@ModelAttribute SignUpFinalFormDto form) {
        // 회원가입 처리 로직 (예: 데이터베이스에 저장)
        log.info("Username: " + form.getUsername());
        log.info("Password: " + form.getPassword());
        log.info("Phone: " + form.getPhone());
        log.info("Name: " + form.getName());
        log.info("Role: " + form.getRole());
        log.info("Birth: " + form.getKidBirth());
        log.info("Gender: " + form.getKidGender());
        log.info("KinderNo: " + form.getKinderNo());
        log.info("ClassNo: " + form.getClassNo());
        log.info("KidName: " + form.getKidName());
        log.info("Relationship: " + form.getRelationship());




        return "redirect:/member/signIn";
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
