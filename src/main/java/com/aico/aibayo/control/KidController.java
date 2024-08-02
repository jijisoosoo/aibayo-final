package com.aico.aibayo.control;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.dto.kid.KidSearchCondition;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.MemberSearchCondition;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.kid.KidService;
import java.util.List;

import com.aico.aibayo.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/kid")
@RequiredArgsConstructor
public class KidController {
    private final KidService kidService;
    private final ClassService classService;
    private final MemberService memberService;
    private final JWTUtil jwtUtil;

    // 나중에는 로그인 사용자 MemberDto 정보에서 가져오기

//    private int roleNo = 1;
//    private Long id = 2L;
//    private Long kinderNo = 1L;

//    private int roleNo = 2;
//    private Long id = 31L;

//    private int roleNo = 3;
//    private Long id = 14L;

    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model) {
//        String username = (String) request.getAttribute("username");
//        String username = "admin";
        String token = getTokenFromCookies(request.getCookies());
        String username = jwtUtil.getUsername(token);
        log.info("loginUser: {}", username);
        MemberDto memberDto = memberService.findByUsername(username);
//        memberDto.setKinderNo(1L);

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

    @GetMapping("/list")
    public String list(Model model) {
        KidSearchCondition condition = new KidSearchCondition();
        return getConditionAndGoList(model, condition);
    }

    @PostMapping("/searchByClass")
    public String searchByClass(@RequestBody KidSearchCondition condition,
                                Model model) {
        log.info("search: {}", condition);

        return getConditionAndGoList(model, condition);
    }

    @GetMapping("/{kidNo}")
    public String detail(@PathVariable Long kidNo, Model model) {
        getConditionAndGoDetail(kidNo, model);

        return "/admin/kid/detail";
    }

    @GetMapping("/user/{kidNo}")
    public String userDetail(@PathVariable Long kidNo, Model model) {
        MemberDto loginInfo = (MemberDto) model.getAttribute("loginInfo");

        // 주보호자 여부 확인
        MemberSearchCondition condition = new MemberSearchCondition();
        condition.setId(loginInfo.getId());
        condition.setKidNo(kidNo);

        MemberDto loginUser = memberService.getByIdAndKidNo(condition);

        model.addAttribute("isMainParent", loginUser.getIsMainParent());

        getConditionAndGoDetail(kidNo, model);

        return "/user/kid/detail";
    }

    @PostMapping("/modifyOk")
    public String modifyOk(@RequestBody KidDto kidDto, Model model) {
        MemberDto loginInfo = (MemberDto) model.getAttribute("loginInfo");
        int roleNo = loginInfo.getRoleNo();

        kidService.updateKidRelation(kidDto);

        getConditionAndGoDetail(kidDto.getKidNo(), model);

        if (roleNo < 2) {
            return "/admin/kid/detail";
        } else if (roleNo == 2) {
            return "/user/kid/detail";
        } else {
            throw new IllegalArgumentException("유효하지 않은 접근입니다.");
        }

    }

    @PutMapping("/modifyOk")
    @ResponseBody
    public ResponseEntity<KidDto> modifyOk(@RequestBody KidDto kidDto) {
        log.info("modify: {}", kidDto);
        KidDto updated = kidService.updateKid(kidDto);

        return updated == null ? ResponseEntity.badRequest().build() :
                                 ResponseEntity.ok(updated);
    }

    @GetMapping("/write")
    public String writeForm() {
        return "/admin/kid/writeForm";
    }

    private void getConditionAndGoDetail(@PathVariable Long kidNo,
                                         Model model) {
        MemberDto loginInfo = (MemberDto) model.getAttribute("loginInfo");

        KidDto kidDto = kidService.getByKidNo(kidNo);
        List<MemberDto> memberDtos = memberService.getAllByKidNo(kidNo);
        List<ClassDto> classDtos = classService.getAllByKidNo(kidNo);
        List<ClassDto> classAllDtos = classService.getByKinderNo(loginInfo.getKinderNo());

        model.addAttribute("kid", kidDto);
        model.addAttribute("members", memberDtos);
        model.addAttribute("classes", classDtos);
        model.addAttribute("allClass", classAllDtos);
    }

    private String getConditionAndGoList(Model model, KidSearchCondition condition) {
        MemberDto loginInfo = (MemberDto) model.getAttribute("loginInfo");

        condition.setKinderNo(loginInfo.getKinderNo());

        condition.setAcceptStatus(AcceptStatusEnum.ACCEPT.getStatus());
        List<KidDto> kidAcceptDtos = kidService.getAllByClassNoAndAcceptStatus(condition);
        model.addAttribute("kidsAccept", kidAcceptDtos);

        condition.setAcceptStatus(AcceptStatusEnum.WAIT.getStatus());
        List<KidDto> kidWaitDtos = kidService.getAllWithParentByClassNoAndAcceptStatus(condition);
        model.addAttribute("kidsWait", kidWaitDtos);

        condition.setAcceptStatus(null);
        condition.setInviteAcceptStatus(AcceptStatusEnum.ACCEPT.getStatus());
        List<KidDto> kidInviteDtos = kidService.getAllWithParentByClassNoAndAcceptStatus(condition);
        model.addAttribute("kidsInvite", kidInviteDtos);

        List<ClassDto> classDtos = classService.getByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classes", classDtos);

        return "/admin/kid/list";
    }
}
