package com.aico.aibayo.service.comment;

import com.aico.aibayo.dto.comment.CommentDto;
import com.aico.aibayo.dto.comment.CommentSearchCondtion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    CommentDto findByBoardNo(Long BoardNo);

    Page<CommentDto>findAllByBoardNo(CommentSearchCondtion condtion, int page);

}
