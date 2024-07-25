package com.aico.aibayo.control;

import com.aico.aibayo.dto.announce.AnnounceDto;
import com.aico.aibayo.dto.announce.AnnounceSearchCondition;
import com.aico.aibayo.service.announce.AnnounceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;


@Slf4j
@Controller
@RequestMapping("/announce")
@RequiredArgsConstructor
public class AnnounceController {
    private final AnnounceService announceService;


    @GetMapping("/admin/card")
    public String admincard(@RequestParam(defaultValue = "1") int page, Model model){
        HashMap<String, Object> hashMap = new HashMap<>();
        AnnounceSearchCondition condition = new AnnounceSearchCondition();
        condition.setKinderNo(1L);
        model.addAttribute("KinderNo",1L);
        hashMap.put("page",page);
        hashMap.put("type","card");
        Page<AnnounceDto>announces= announceService.findAllByKinderNoCard(condition,hashMap);


        return getPageInfoAndGoView(model, announces, "/announce/admin/card");
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
            condition1.setKinderNo(1L);

            condition2.setKinderNo(1L);
            condition2.setAnnouncePrimary("1");

            model.addAttribute("KinderNo",1L);
            hashMap1.put("page",page);
            hashMap1.put("type","list");
            hashMap2.put("page",1);
            hashMap2.put("type","listPrimary");

            Page<AnnounceDto>announces= announceService.findAllByKinderNoList(condition1,hashMap1);
            Page<AnnounceDto>primaryAnnounces= announceService.findAllByKinderNoList(condition2,hashMap2);

            return getPageInfoAndGoView(model, announces, primaryAnnounces, "/announce/admin/list");
        }

    @GetMapping("/admin/writeForm")
    public String writeForm(){
        return "/announce/admin/writeForm";
    }
    @GetMapping("/admin/detail")
    public String admindetail(){
        return "/announce/admin/detail";
    }
    @GetMapping("/admin/modifyForm")
    public String modifyForm(){
        return "/announce/admin/modifyForm";
    }
    //    user
    @GetMapping("/user/card")
    public String usercard(){
        return "/announce/user/card";
    }
    @GetMapping("/user/list")
    public String userList(){
        return "/announce/user/list";
    }
    @GetMapping("/user/detail")
    public String userdetail(){
        return "/announce/user/detail";
    }





}

