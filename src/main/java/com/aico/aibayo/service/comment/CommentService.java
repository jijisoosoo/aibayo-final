package com.aico.aibayo.service.comment;

import com.aico.aibayo.dto.comment.CommentDto;
import com.aico.aibayo.dto.comment.CommentSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface CommentService {
    Page<CommentDto>findAllByBoardNo(CommentSearchCondition condition, HashMap<String, Object> hashMap);
}
