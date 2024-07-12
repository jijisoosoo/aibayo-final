package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medication")
public class MedicationController {
    @GetMapping("/admin/card")
    public String admincard(){
        return "/medication/admin/card";
    }
}
