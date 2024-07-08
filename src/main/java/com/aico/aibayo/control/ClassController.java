package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classManage")
public class ClassController {

    @GetMapping("/main")
    public String main() {
        return "classManage/main";
    }

}
