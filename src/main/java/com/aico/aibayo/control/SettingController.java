package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setting")
public class SettingController {
    @GetMapping("/menu")
    public String menu(){
        return "/admin/setting/menu";
    }
//    @GetMapping("/function")
//    public String function(){
//        return "/setting/function";
//    }
    //펑션은 안하기로 했음요 !
    @GetMapping("/add")
    public String add(){
        return "/admin/setting/add";
    }
    @GetMapping("/modify")
    public String modify(){
        return "/admin/setting/modify";
    }
    @GetMapping("/info")
    public String info(){
        return "/admin/setting/info";
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/test")
    public String test(){
        return "/admin/setting/copy";
    }



}
