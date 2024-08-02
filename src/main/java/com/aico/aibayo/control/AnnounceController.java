package com.aico.aibayo.control;

import com.aico.aibayo.common.BoardTypeEnum;
import com.aico.aibayo.dto.ClassDto;
    import com.aico.aibayo.dto.announce.AnnounceDto;
import com.aico.aibayo.dto.announce.AnnounceSearchCondition;
import com.aico.aibayo.dto.comment.CommentSearchCondition;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.member.MemberSearchCondition;
import com.aico.aibayo.service.announce.AnnounceService;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/announce")
@RequiredArgsConstructor
public class AnnounceController {
    private final AnnounceService announceService;
    private final ClassService classService;
    private final MemberService memberService;

    // 나중에는 로그인 사용자 MemberDto 정보에서 가져오기
    private int roleNo = 1;
    private Long id = 2L;
    private Long kinderNo = 1L;

    @GetMapping("/admin/card")
    public String admincard(@RequestParam(defaultValue = "1") int page, Model model){
        HashMap<String, Object> hashMap = new HashMap<>();
        AnnounceSearchCondition condition = new AnnounceSearchCondition();
        condition.setKinderNo(kinderNo);
        model.addAttribute("KinderNo",kinderNo);
        hashMap.put("page",page);
        hashMap.put("type","card");
        Page<AnnounceDto>announces= announceService.findAllByKinderNoCard(condition,hashMap);


        return getPageInfoAndGoView(model, announces, "/admin/announce/card");
    }
    private String getPageInfoAndGoView(Model model, Page<AnnounceDto> announces, String view) {
        int totalPages = announces.getTotalPages();
        int currentPage = announces.getNumber();
        int startPage = Math.max(0, currentPage - 2);
        int endPage = Math.min(totalPages - 1, currentPage + 2);

        // 조회된 결과가 없을 때 endPage를 0으로 설정
        if (totalPages == 0) {
            endPage = 0;
        } else {// 페이지 5개 범위 확인
            if (endPage - startPage < 4) {
                if (startPage == 0) {
                    endPage = Math.min(4, totalPages - 1);
                } else if (endPage == totalPages - 1) {
                    startPage = Math.max(0, totalPages - 5);
                }
            }
        }

        log.info(">>>>>>>>>>>>>>>>>>>>>>pagination");
        log.info("startPage: {}", startPage);
        log.info("endPage: {}", endPage);
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        model.addAttribute("announces", announces);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return view;
    }
    private String getPageInfoAndGoView(Model model, Page<AnnounceDto> announces,Page<AnnounceDto> primaryAnnounces, String view) {
        int totalPages = announces.getTotalPages();
        int currentPage = announces.getNumber();
        int startPage = Math.max(0, currentPage - 2);
        int endPage = Math.min(totalPages - 1, currentPage + 2);

        // 조회된 결과가 없을 때 endPage를 0으로 설정
        if (totalPages == 0) {
            endPage = 0;
        } else {// 페이지 5개 범위 확인
            if (endPage - startPage < 4) {
                if (startPage == 0) {
                    endPage = Math.min(4, totalPages - 1);
                } else if (endPage == totalPages - 1) {
                    startPage = Math.max(0, totalPages - 5);
                }
            }
        }

        log.info(">>>>>>>>>>>>>>>>>>>>>>pagination");
        log.info("startPage: {}", startPage);
        log.info("endPage: {}", endPage);
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        model.addAttribute("announces", announces);
        model.addAttribute("primaryAnnounces", primaryAnnounces);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return view;
    }
    @GetMapping("/admin/list")
        public String adminList(@RequestParam(defaultValue = "1") int page, Model model){
            HashMap<String, Object> hashMap1 = new HashMap<>();
            HashMap<String, Object> hashMap2 = new HashMap<>();
            AnnounceSearchCondition condition1 = new AnnounceSearchCondition();
            AnnounceSearchCondition condition2 = new AnnounceSearchCondition();
            condition1.setKinderNo(kinderNo);

            condition2.setKinderNo(kinderNo);
            condition2.setAnnouncePrimary("1");

            model.addAttribute("KinderNo",kinderNo);
            hashMap1.put("page",page);
            hashMap1.put("type","list");
            hashMap2.put("page",1);
            hashMap2.put("type","listPrimary");

            Page<AnnounceDto>announces= announceService.findAllByKinderNoList(condition1,hashMap1);
            Page<AnnounceDto>primaryAnnounces= announceService.findAllByKinderNoList(condition2,hashMap2);

            return getPageInfoAndGoView(model, announces, primaryAnnounces, "/admin/announce/list");
        }

    @GetMapping("/admin/write")
    public String writeForm(Model model){
        // 나중에는 로그인 사용자 MemberDto 정보에서 가져오기
        List<ClassDto> classDtos = new ArrayList<>();

        if (roleNo < 2) { // 사이트 관리자/원장
            classDtos = classService.getByKinderNo(kinderNo);

        } else if (roleNo == 2) { // 교사
            classDtos = classService.getByMemberId(id);
        }
        HashMap<String, Object> announceInfo = new HashMap<>();
        announceInfo.put("boardType", BoardTypeEnum.ANNOUNCE.getNum());
        announceInfo.put("writer", id);
        announceInfo.put("boardKinderNo", kinderNo);

        model.addAttribute("classDtos", classDtos);
        model.addAttribute("announceInfo",announceInfo);

        return "/admin/announce/writeForm";
    }
    @PostMapping("/writeOk")
    @ResponseBody
    public void writeOk(@RequestBody AnnounceDto announceDto) {
        log.info("create Announce: {}", announceDto);

        announceService.insertAnnounce(announceDto);
    }

    @GetMapping("/admin/{announceNo}")
    public String admindetail(@PathVariable Long announceNo, Model model){
        AnnounceDto announceDto = announceService.findByAnnounceNo(announceNo);

        CommentSearchCondition condition = new CommentSearchCondition();
//        Page<CommentDto> commentDto=commentService.findAllByBoardNo(condition,1);

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>announceDto>>>>>{}",announceDto);
//        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>commentDto>>>>>{}",commentDto);

        model.addAttribute("announce",announceDto);
        return "/admin/announce/detail";
    }



    @GetMapping("/admin/modify/{announceNo}")
    public String modifyForm(@PathVariable Long announceNo, Model model){
        HashMap<String, Object> memberDto = new HashMap<>();
        memberDto.put("roleNo", roleNo);
        memberDto.put("id", id);

        AnnounceDto announceDto = announceService.findByAnnounceNo(announceNo);
        model.addAttribute("member",memberDto);
        model.addAttribute("announce",announceDto);
        // 현재 시간 가져오기
        LocalDateTime now = LocalDateTime.now();
        // 모델에 추가
        model.addAttribute("boardModifyDate", now);

        return "/admin/announce/modifyForm";
    }
    @PutMapping("/modifyOk")
    @ResponseBody
    public void modify(@RequestBody AnnounceDto announceDto) {
        log.info("modify announce: {}", announceDto);
        announceService.updateAnnounce(announceDto);
    }
    @DeleteMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody AnnounceDto announceDto) {
        log.info("delete: {}", announceDto);
        announceService.deleteAnnounce(announceDto);
    }





    //    user
    @GetMapping("/user/card")
    public String usercard(@RequestParam(defaultValue = "1") int page, Model model){
        MemberSearchCondition memberSearchCondition = new MemberSearchCondition();
        memberSearchCondition.setId(14L);
        memberSearchCondition.setKidNo(1L);
        MemberDto loginInfo=  memberService.getByIdAndKidNo(memberSearchCondition);
        HashMap<String, Object> hashMap = new HashMap<>();
        AnnounceSearchCondition condition = new AnnounceSearchCondition();
        AnnounceSearchCondition condition1 = new AnnounceSearchCondition();
        condition.setKinderNo(kinderNo);
        if (condition1.getAnnounceType() != null && condition1.getAnnounceType() == 0) {
            condition1.setAnnounceType(null); // 0이면 조건을 제거 (null로 설정)
        }
        model.addAttribute("KinderNo",kinderNo);
        hashMap.put("page",page);
        hashMap.put("type","card");
        Page<AnnounceDto>announces= announceService.findAllByKinderNoCard(condition,hashMap);


        return getPageInfoAndGoView(model, announces, "/user/announce/card");
    }
    @GetMapping("/user/list")
    public String userList(@RequestParam(defaultValue = "1") int page, Model model){
        HashMap<String, Object> hashMap1 = new HashMap<>();
        HashMap<String, Object> hashMap2 = new HashMap<>();
        AnnounceSearchCondition condition1 = new AnnounceSearchCondition();
        AnnounceSearchCondition condition2 = new AnnounceSearchCondition();
        condition1.setKinderNo(kinderNo);

        condition2.setKinderNo(kinderNo);
        condition2.setAnnouncePrimary("1");


        model.addAttribute("KinderNo",kinderNo);
        hashMap1.put("page",page);
        hashMap1.put("type","list");
        hashMap2.put("page",1);
        hashMap2.put("type","listPrimary");

        Page<AnnounceDto>announces= announceService.findAllByKinderNoList(condition1,hashMap1);
        Page<AnnounceDto>primaryAnnounces= announceService.findAllByKinderNoList(condition2,hashMap2);

        return getPageInfoAndGoView(model, announces, primaryAnnounces, "/user/announce/list");
    }
    @GetMapping("/user/{announceNo}")
    public String userdetail(@PathVariable Long announceNo, Model model){
        AnnounceDto announceDto = announceService.findByAnnounceNo(announceNo);

        CommentSearchCondition condition = new CommentSearchCondition();
//        Page<CommentDto> commentDto=commentService.findAllByBoardNo(condition,1);

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>announceDto>>>>>{}",announceDto);
//        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>commentDto>>>>>{}",commentDto);

        model.addAttribute("announce",announceDto);
        return "/user/announce/detail";
    }





}

