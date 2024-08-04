package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classManage")
public class ClassManageController {

    @GetMapping("/main")
    public String mainPage() {
        return "/admin/classManage/main";
    }

}
