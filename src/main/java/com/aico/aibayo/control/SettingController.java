package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setting")
public class SettingController {
    @GetMapping("/menu")
    public String menu(){
        return "/setting/menu";
    }
    @GetMapping("/function")
    public String function(){
        return "/setting/function";
    }
}
