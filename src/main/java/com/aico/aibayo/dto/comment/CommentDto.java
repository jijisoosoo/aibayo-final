package com.aico.aibayo.dto.comment;

import lombok.*;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long announceNo;

    private Integer roleNo;
    private String name;
    private Long kinderNo;

    private Long boardNo;
    private Integer commentGroupNo;
    private LocalDateTime commentRegDate;
    private Long commentWriter;
    private String commentClass;
    private String commentContent;
    private String commentDeleteFlag;


    public CommentDto(
            Integer roleNo, String name, Long kinderNo, Long boardNo, Integer commentGroupNo,
            LocalDateTime commentRegDate, Long commentWriter, String commentClass,
            String commentContent, String commentDeleteFlag
    ){
        this.roleNo = roleNo;
        this.name = name;
        this.kinderNo = kinderNo;
        this.boardNo = boardNo;
        this.commentGroupNo = commentGroupNo;
        this.commentRegDate = commentRegDate;
        this.commentWriter = commentWriter;
        this.commentClass = commentClass;
        this.commentContent = commentContent;
        this.commentDeleteFlag = commentDeleteFlag;
    }

}
