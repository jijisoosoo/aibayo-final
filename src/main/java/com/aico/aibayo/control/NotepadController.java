package com.aico.aibayo.control;

import com.aico.aibayo.dto.NotepadDto;
//import com.aico.aibayo.service.NotepadService;
import com.aico.aibayo.dto.NotepadSearchCondition;
import com.aico.aibayo.service.NotepadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

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
        NotepadSearchCondition condition = new NotepadSearchCondition();
        condition.setKinderNo(1L);

        Page<NotepadDto> notepads = notepadService.getAllByKinderNo(condition, page);

        // 페이지네이션에 필요한 정보
        return getPageInfoAndGoView(model, notepads);
    }

    @PostMapping("/admin/searchDate")
    public String searchDate(@RequestBody NotepadSearchCondition condition,
                             Model model) {
        log.info("{}", condition);

        Page<NotepadDto> notepads = notepadService.getAllByKinderNo(condition);

        // 페이지네이션에 필요한 정보
        return getPageInfoAndGoView(model, notepads);
    }

    private String getPageInfoAndGoView(Model model, Page<NotepadDto> notepads) {
        int totalPages = notepads.getTotalPages();
        int currentPage = notepads.getNumber();
        int startPage = Math.max(0, currentPage - 2);
        int endPage = Math.min(totalPages - 1, currentPage + 2);

        if (endPage - startPage < 4) {
            if (startPage == 0) {
                endPage = Math.min(4, totalPages - 1);
            } else if (endPage == totalPages - 1) {
                startPage = Math.max(0, totalPages - 5);
            }
        }

        model.addAttribute("notepads", notepads);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

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
