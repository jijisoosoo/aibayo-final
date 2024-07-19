package com.aico.aibayo.control;

import com.aico.aibayo.dto.NotepadDto;
//import com.aico.aibayo.service.NotepadService;
import com.aico.aibayo.service.NotepadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/notepad")
@RequiredArgsConstructor
public class NotepadController {
    private final NotepadService notepadService;

    @GetMapping("/admin/list")
    public String adminList(@RequestParam(defaultValue = "1") int page, Model model) {
        // 역할에 따라 사용자/관리자 구분하여 이동
        // 사용자의 유치원번호의 사용자가 등록한 모든 알림장 조회
        Page<NotepadDto> notepads = notepadService.getAllByKinderNo(1L, page);
        model.addAttribute("notepads", notepads);

        log.info("getPageNumber: {}", notepads.getPageable().getPageNumber());
        log.info("getOffset: {}", notepads.getPageable().getOffset());
        log.info("hasPrevious: {}", notepads.getPageable().hasPrevious());
        log.info("first: {}", notepads.getPageable().first());
        log.info("next: {}", notepads.getPageable().next());
        log.info("getTotalPages: {}", notepads.getTotalPages());

        return "/notepad/admin/list";
    }

    @GetMapping("/user/list")
    public String userList() {
        return "/notepad/user/list";
    }

    // 나중에 detail 대신 notepadNo 대신 가져오기
    @GetMapping("/admin/{notepadNo}")
    public String adminDetail(@PathVariable Long notepadNo) {
        
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
