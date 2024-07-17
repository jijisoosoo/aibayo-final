package com.aico.aibayo.control;

import com.aico.aibayo.dto.NotepadDto;
//import com.aico.aibayo.service.NotepadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notepad")
@RequiredArgsConstructor
public class NotepadController {
//    private final NotepadService notepadService;

    @GetMapping("/admin/list")
    public String adminList() {
        // 역할에 따라 사용자/관리자 구분하여 이동
        // 사용자의 유치원번호의 사용자가 등록한 모든 알림장 조회
//        List<NotepadDto> notepads = notepadService.getAllByKinderNo(1);

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
