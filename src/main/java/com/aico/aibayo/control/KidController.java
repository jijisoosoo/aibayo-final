package com.aico.aibayo.control;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.dto.kid.KidSearchCondition;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.kid.KidService;
import com.aico.aibayo.service.kid.KidServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/kid")
@RequiredArgsConstructor
public class KidController {
    private final KidService kidService;
    private final ClassService classService;
    private final KidServiceImpl kidServiceImpl;

    // 나중에는 로그인 사용자 MemberDto 정보에서 가져오기
    private int roleNo = 1;
    private Long id = 2L;
    private Long kinderNo = 1L;

//    private int roleNo = 2;
//    private Long id = 31L;

    @GetMapping("/list")
    public String list(Model model) {
        KidSearchCondition condition = new KidSearchCondition();
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

        return "/kid/list";
    }

    @PostMapping("/searchByClass")
    public String searchByClass(@RequestBody KidSearchCondition condition,
                                Model model) {
        log.info("search: {}", condition);

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

        return "/kid/list";
    }

    @GetMapping("/{kidNo}")
    public String detail(@PathVariable Long kidNo) {


        return "/kid/detail";
    }

    @GetMapping("/user/detail")
    public String userDetail() {
        return "/kid/user_detail";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "/kid/writeForm";
    }
}
