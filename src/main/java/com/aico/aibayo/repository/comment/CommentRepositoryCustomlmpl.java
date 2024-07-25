package com.aico.aibayo.repository.comment;

import com.aico.aibayo.dto.comment.CommentDto;
import com.aico.aibayo.dto.comment.CommentSearchCondtion;
import com.aico.aibayo.entity.QBoardEntity;
import com.aico.aibayo.entity.QCommentEntity;
import com.aico.aibayo.entity.QMemberEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RequiredArgsConstructor
public class CommentRepositoryCustomlmpl implements CommentRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QCommentEntity comment = QCommentEntity.commentEntity;
    private final QBoardEntity board = QBoardEntity.boardEntity;
    private final QMemberEntity member =QMemberEntity.memberEntity;


    @Override
    public CommentDto findByBoardNo(Long BoardNo) {
        return null;
    }

    @Override
    public Page<CommentDto> findAllByBoardNo(CommentSearchCondtion condition, Pageable pageable) {
//        List<CommentDto>comments=jpaQueryFactory
//                .select(Projections.constructor(CommentDto.class,
//                        member.roleNo,
//                        member.name,
//                        member.kinderNo,
//                        comment.boardNo,
//                        comment.commentGroupNo,
//                        comment.commentRegDate,
//                        comment.commentContent,
//                        comment.commentDeleteFlag))
        return null;
    }
}
