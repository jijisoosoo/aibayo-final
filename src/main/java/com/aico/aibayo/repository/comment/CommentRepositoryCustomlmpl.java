package com.aico.aibayo.repository.comment;

import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.comment.CommentDto;
import com.aico.aibayo.dto.comment.CommentSearchCondition;
import com.aico.aibayo.entity.QBoardEntity;
import com.aico.aibayo.entity.QCommentEntity;
import com.aico.aibayo.entity.QMemberEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;


@RequiredArgsConstructor
public class CommentRepositoryCustomlmpl implements CommentRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QCommentEntity comment = QCommentEntity.commentEntity;
    private final QBoardEntity board = QBoardEntity.boardEntity;
    private final QMemberEntity member =QMemberEntity.memberEntity;



    @Override
    public Page<CommentDto> findAllByBoardNo(CommentSearchCondition condition, Pageable pageable) {
        List<CommentDto> comments = jpaQueryFactory
                .select(Projections.constructor(CommentDto.class,
                        member.roleNo,
                        member.name,
                        member.kinderNo,
                        comment.boardNo,
                        comment.commentGroupNo,
                        comment.commentRegDate,
                        comment.commentWriter,
                        comment.commentClass,
                        comment.commentContent,
                        comment.commentDeleteFlag
                ))
                .from(comment)
                .join(board).on(board.boardNo.eq(comment.boardNo))
                .leftJoin(member).on(board.writer.eq(member.id))
                .where(
                        getInvisibleFlagEq(board)
                )
                .orderBy(
                        comment.commentGroupNo.desc(),
                        comment.commentRegDate.asc()
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = jpaQueryFactory.select(comment.count())
                .from(comment)
                .join(board).on(board.boardNo.eq(comment.boardNo))
                .join(member).on(board.writer.eq(member.id))
                .where(
                        getInvisibleFlagEq(board)
                );

        return PageableExecutionUtils.getPage(comments, pageable, count::fetchOne);
    }
    private BooleanExpression getInvisibleFlagEq(QBoardEntity board) {
        return board.invisibleFlag.eq(BooleanEnum.FALSE.getBool());
    }
}

