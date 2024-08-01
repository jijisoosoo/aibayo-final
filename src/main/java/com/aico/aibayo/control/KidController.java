package com.aico.aibayo.control;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.dto.kid.KidSearchCondition;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.MemberSearchCondition;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.kid.KidService;
import java.util.List;

import com.aico.aibayo.service.member.MemberService;
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

    // 나중에는 로그인 사용자 MemberDto 정보에서 가져오기
    private int roleNo = 1;
    private Long id = 2L;
    private Long kinderNo = 1L;

//    private int roleNo = 2;
//    private Long id = 31L;

//    private int roleNo = 3;
//    private Long id = 14L;

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
        // 주보호자 여부 확인
        MemberSearchCondition condition = new MemberSearchCondition();
        condition.setId(id);
        condition.setKidNo(kidNo);

        MemberDto loginUser = memberService.getByIdAndKidNo(condition);

        model.addAttribute("isMainParent", loginUser.getIsMainParent());

        getConditionAndGoDetail(kidNo, model);

        return "/user/kid/detail";
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
        return "/kid/writeForm";
    }

    private void getConditionAndGoDetail(@PathVariable Long kidNo,
                                         Model model) {
        KidDto kidDto = kidService.getByKidNo(kidNo);
        List<MemberDto> memberDtos = memberService.getAllByKidNo(kidNo);
        List<ClassDto> classDtos = classService.getAllByKidNo(kidNo);
        List<ClassDto> classAllDtos = classService.getByKinderNo(kinderNo);

        model.addAttribute("kid", kidDto);
        model.addAttribute("members", memberDtos);
        model.addAttribute("classes", classDtos);
        model.addAttribute("allClass", classAllDtos);
    }

    private String getConditionAndGoList(Model model, KidSearchCondition condition) {
        condition.setKinderNo(kinderNo);

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

        List<ClassDto> classDtos = classService.getByKinderNo(kinderNo);
        model.addAttribute("classes", classDtos);

        return "/admin/kid/list";
    }
}
