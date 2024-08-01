package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/returnhome")
    public class ReturnHomeController {
        @GetMapping("/admin/card")
        public String admincard(){
            return "/admin/returnHome/card";
        }
        @GetMapping("/admin/list")
        public String adminlist(){
            return "/admin/returnHome/list";
        }
        @GetMapping("/admin/detail")
        public String admindetail(){
            return "/admin/returnHome/detail";
        }
        @GetMapping("/user/writeform")
        public String write() {
            return "/user/returnHome/writeForm";
        }
        @GetMapping("/user/detail")
        public String userdetail(){
            return "/user/returnHome/detail";
        }
        @GetMapping("/user/card")
        public String usercard(){
            return "/user/returnHome/card";
        }
        @GetMapping("/user/list")
        public String userlist(){
            return "/user/returnHome/list";
        }
}
