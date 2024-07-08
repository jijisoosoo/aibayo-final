package com.aico.aibayo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notepad")
public class NotepadController {
    @GetMapping("/admin/list")
    public String adminList() {
        // 역할에 따라 사용자/관리자 구분하여 이동
        return "/notepad/admin/list";
    }

    @GetMapping("/user/list")
    public String userList() {
        return "/notepad/user/list";
    }

    // 나중에 detail 대신 boardno 대신 가져오기
    @GetMapping("/admin/detail")
    public String adminDetail() {
        return "/notepad/admin/detail";
    }

    @GetMapping("/user/detail")
    public String userDetail() {
        return "/notepad/user/detail";
    }

    // 나중에는 post(put)로
    @GetMapping("/admin/modify")
    public String modifyForm() {
        return "/notepad/admin/modifyForm";
    }

    @GetMapping("/admin/write")
    public String writeForm() {
        return "/notepad/admin/writeForm";
    }
}
