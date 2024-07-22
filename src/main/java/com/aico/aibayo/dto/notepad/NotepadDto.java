package com.aico.aibayo.dto.notepad;

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
    private Long writer;
    private String boardTitle;
    private String boardContents;
    private String invisibleFlag;
    private LocalDateTime boardRegDate;

    private Long id;
    private String name;
    private Long kinderNo;

    private Long notepadNo;
    private String hasLifeRecord;

    private int mood;
    private int health;
    private int temperature;
    private int meal;
    private int sleepTime;
    private int defecationStatus;

    public NotepadDto(Long boardNo, Integer boardType, Long writer, String boardTitle,
                      String boardContents, String invisibleFlag, LocalDateTime boardRegDate,
                      Long id, String name, Long kinderNo, Long notepadNo) {
        this.boardNo = boardNo;
        this.boardType = boardType;
        this.writer = writer;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.invisibleFlag = invisibleFlag;
        this.boardRegDate = boardRegDate;
        this.id = id;
        this.name = name;
        this.kinderNo = kinderNo;
        this.notepadNo = notepadNo;
    }
}
