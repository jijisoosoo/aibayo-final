package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/announce")
public class AnnounceController {
    @GetMapping("/admin/list")
    public String adminList(){
        return "/announce/admin/list";
    }


    @GetMapping("/admin/writeForm")
    public String writeForm(){
        return "/announce/admin/writeForm";
    }


}

