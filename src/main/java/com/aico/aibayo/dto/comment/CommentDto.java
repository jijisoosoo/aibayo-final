package com.aico.aibayo.dto.comment;

import lombok.*;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {


    private Integer roleNo;
    private String name;
    private Integer kinderNo;

    private Long boardNo;
    private Integer commentGroupNo;
    private LocalDateTime commentRegDate;
    private Long commentWriter;
    private String commentClass;
    private String commentContent;
    private String commentDeleteFlag;


}
