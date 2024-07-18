package com.aico.aibayo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NotepadDto {
    private Long boardNo;
    private Integer boardType;
    private String writer;
    private String boardTitle;
    private String boardContents;
    private String invisibleFlag;
    private LocalDateTime boardRegDate;

    private Long id;
    private Long kinderNo;

    private Long notepadNo;
}
