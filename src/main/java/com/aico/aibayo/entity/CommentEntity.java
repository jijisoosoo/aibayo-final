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
    private Long commentNo;
    @Column(name="board_no")
    private int boardNo;
    @Column(name="parent_comment_no")
    private int parentCommentNo;
    @Column(name="comment_writer")
    private String commentWriter;
    @Column(name="comment_reg_date")
    private LocalDateTime commentRegDate;
    @Column(name="comment_modify_date")
    private LocalDateTime commentModifyDate;
    @Column(name="comment_delete_date")
    private LocalDateTime commentDeleteDate;
    @Column(name="comment_content")
    private String commentContent;
    @Column(name="invisible_flag")
    private String invisibleFlag;
    @Column(name="comment_class")
    private String commentClass;
    @Column(name="comment_order")
    private int commentOrder;
    @Column(name="commnet_group_no")
    private int commnetGroupNo;
}
