package com.aico.aibayo.service.comment;

import com.aico.aibayo.dto.comment.CommentDto;
import com.aico.aibayo.dto.comment.CommentSearchCondition;
import com.aico.aibayo.repository.BoardRepository;
import com.aico.aibayo.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    private static final int PAGE_SIZE=10;


    @Override
    public Page<CommentDto> findAllByBoardNo(CommentSearchCondition condition, int page) {
        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE);

        return commentRepository.findAllByBoardNo(condition, pageable);
    }
}
