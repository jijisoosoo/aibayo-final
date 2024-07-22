package com.aico.aibayo.dto.announce;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AnnounceDto {
    private Long boardNo;
    private Integer boardType;
    private Long writer;
    private String boardTitle;
    private String boardContents;
    private String invisibleFlag;
    private LocalDateTime boardRegDate;

    private Long announceNo;
    private Integer announceType;
    private String canComment;
    private String announcePrimary;

    private Long id;
    private String isRead;


}
