package com.aico.aibayo.control;

import com.aico.aibayo.dto.comment.CommentDto;
import com.aico.aibayo.dto.comment.CommentSearchCondition;
import com.aico.aibayo.service.comment.CommentService;
import com.aico.aibayo.service.kid.KidService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Slf4j
@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final KidService kidService;

    // 나중에는 로그인 사용자 MemberDto 정보에서 가져오기
    private int roleNo = 1;
    private Long id = 2L;
    private Long kinderNo = 1L;

    @GetMapping("/{announceNo}")
    public String comment(@PathVariable Long announceNo, @RequestParam(defaultValue = "1") int page, Model model) {
        HashMap<String, Object> hashMap = new HashMap<>();
        CommentSearchCondition condition = new CommentSearchCondition();
        condition.setKinderNo(kinderNo);

        model.addAttribute("KinderNo", kinderNo);
        hashMap.put("page", page);
        hashMap.put("type", "list");

        Page<CommentDto> comments = commentService.findAllByBoardNo(condition, hashMap);

        return getPageInfoAndGoView(model, comments, "/comment/list");
    }

    private String getPageInfoAndGoView(Model model, Page<CommentDto> comments, String view) {
        int totalPages = comments.getTotalPages();
        int currentPage = comments.getNumber();
        int startPage = Math.max(0, currentPage - 2);
        int endPage = Math.min(totalPages - 1, currentPage + 2);

        // 조회된 결과가 없을 때 endPage를 0으로 설정
        if (totalPages == 0) {
            endPage = 0;
        } else { // 페이지 5개 범위 확인
            if (endPage - startPage < 4) {
                if (startPage == 0) {
                    endPage = Math.min(4, totalPages - 1);
                } else if (endPage == totalPages - 1) {
                    startPage = Math.max(0, totalPages - 5);
                }
            }
        }

        log.info(">>>>>>>>>>>>>>>>>>>>>>pagination");
        log.info("startPage: {}", startPage);
        log.info("endPage: {}", endPage);
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        model.addAttribute("comments", comments);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return view;
    }
}
