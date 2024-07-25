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

    private Integer roleNo;
    private String name;

    private Integer commentGroupNo;
    private LocalDateTime commentRegDate;
    private Long commentWriter;
    private String commentClass;
    private String commentContent;
    private String commentDeleteFlag;

    public AnnounceDto(
                Integer announceType,Long announceNo,String announcePrimary,String canComment,Integer boardType,
                Long boardNo, Long writer, String boardContents, String boardTitle, String invisibleFlag,
                LocalDateTime boardRegDate, Integer roleNo, Long id, String name){
                    this.announceType=announceType;
                    this.announceNo=announceNo;
                    this.announcePrimary=announcePrimary;
                    this.canComment=canComment;
                    this.boardType=boardType;
                    this.boardNo=boardNo;
                    this.writer=writer;
                    this.boardContents=boardContents;
                    this.boardTitle=boardTitle;
                    this.invisibleFlag=invisibleFlag;
                    this.boardRegDate=boardRegDate;
                    this.roleNo=roleNo;
                    this.id=id;
                    this.name=name;
    }
    public AnnounceDto(
            Integer announceType,Long announceNo,String announcePrimary,String canComment,Integer boardType,
            Long boardNo, Long writer, String boardContents, String boardTitle, String invisibleFlag,
            LocalDateTime boardRegDate, Integer roleNo, Long id, String name,
            Integer commentGroupNo,LocalDateTime commentRegDate,Long commentWriter,
            String commentClass,String commentContent, String commentDeleteFlag){
                this.announceType=announceType;
                this.announceNo=announceNo;
                this.announcePrimary=announcePrimary;
                this.canComment=canComment;
                this.boardType=boardType;
                this.boardNo=boardNo;
                this.writer=writer;
                this.boardContents=boardContents;
                this.boardTitle=boardTitle;
                this.invisibleFlag=invisibleFlag;
                this.boardRegDate=boardRegDate;
                this.roleNo=roleNo;
                this.id=id;
                this.name=name;
                this.commentGroupNo=commentGroupNo;
                this.commentRegDate=commentRegDate;
                this.commentWriter=commentWriter;
                this.commentClass=commentClass;
                this.commentContent=commentContent;
                this.commentDeleteFlag=commentDeleteFlag;
    }
}
