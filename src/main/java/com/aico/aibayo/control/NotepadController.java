package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notepad")
public class NotepadController {
    @GetMapping("/list")
    public String list() {
        // 역할에 따라 사용자/관리자 구분하여 이동
        return "/notepad/admin/list";
    }
}
