package com.aico.aibayo.control;

import com.aico.aibayo.service.announce.AnnounceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/announce")
@RequiredArgsConstructor
public class AnnounceController {
//    private final AnnounceService announceService;

    @GetMapping("/admin/card")
    public String admincard(){


        return "/announce/admin/card";
    }
    @GetMapping("/admin/list")
    public String adminList(){
        return "/announce/admin/list";
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

