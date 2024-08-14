package com.aico.aibayo.dto.schedule;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleDto {
    private LocalDateTime boardDeleteDate;
    private LocalDateTime boardModifyDate;
    private LocalDateTime boardRegDate;
    private LocalDateTime scheduleStartDate;
    private LocalDateTime scheduleEndDate;
    private Long boardNo;
    private Long scheduleNo;
    private Long kinderNo;
    private Long classNo;
    private String boardTitle;
    private Long writer;
    private String boardContents;

    public ScheduleDto(Long boardNo, Long scheduleNo, Long kinderNo, Long classNo,
                       String boardTitle, Long writer, String boardContents,
                       LocalDateTime scheduleStartDate, LocalDateTime scheduleEndDate){
        this.boardNo = boardNo;
        this.scheduleNo = scheduleNo;
        this.kinderNo = kinderNo;
        this.classNo = classNo;
        this.boardTitle = boardTitle;
        this.writer = writer;
        this.boardContents = boardContents;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleEndDate = scheduleEndDate;
    }

}
