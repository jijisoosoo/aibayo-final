package com.aico.aibayo.repository.comment;

import com.aico.aibayo.dto.comment.CommentDto;
import com.aico.aibayo.dto.comment.CommentSearchCondtion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepositoryCustom {

    CommentDto findByBoardNo(Long BoardNo);

    Page<CommentDto>findAllByBoardNo(CommentSearchCondtion condtion, Pageable pageable);
}
