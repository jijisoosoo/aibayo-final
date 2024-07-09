package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setting")
public class SettingController {
    @GetMapping("/setting/menu")
    public String settingMenu(){
        return "/setting/menu";
    }
}
