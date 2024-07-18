package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/returnhome")
    public class ReturnHomeController {
        @GetMapping("/admin/card")
        public String admincard(){
            return "/returnHome/admin/card";
        }
        @GetMapping("/admin/list")
        public String adminlist(){
            return "/returnHome/admin/list";
        }
        @GetMapping("/admin/detail")
        public String admindetail(){
            return "/returnHome/admin/detail";
        }
        @GetMapping("/user/writeform")
        public String write() {
            return "/returnHome/user/writeForm";
        }
        @GetMapping("/user/detail")
        public String userdetail(){
            return "/returnHome/user/detail";
        }
        @GetMapping("/user/card")
        public String usercard(){
            return "/returnHome/user/card";
        }
        @GetMapping("/user/list")
        public String userlist(){
            return "/returnHome/user/list";
        }
}
