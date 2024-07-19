package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString


public class CommentEntity {
    @Id
    @Column(name="comment_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo; //댓글번호
    @Column(name="board_no")
    private Long boardNo; //게시글 번호
    @Column(name="parent_comment_no")
    private Integer parentCommentNo; //댓글 번호
    @Column(name="comment_writer")
    private String commentWriter; //댓글 작성자
    @Column(name="comment_reg_date")
    private LocalDateTime commentRegDate; //댓글 작성일자
    @Column(name="comment_modify_date")
    private LocalDateTime commentModifyDate; //댓글 수정일자
    @Column(name="comment_delete_date")
    private LocalDateTime commentDeleteDate;//댓글 삭제일자
    @Column(name="comment_content")
    private String commentContent; //댓글 내용
    @Column(name="invisible_flag")
    private String invisibleFlag;//삭제 여부
    @Column(name="comment_class")
    private String commentClass;//댓글 구분 (0:댓글 1:대댓글)
    @Column(name="comment_order")
    private Integer commentOrder; //댓글 순서(따로 컬럼줘서 orderby안해도 되게)
    @Column(name="commnet_group_no")
    private Integer commnetGroupNo;//댓글그룹(댓글-댓글번호/ 대댓글-부모 댓글번호 저장)
}
