package com.aico.aibayo.dto.announce;

import com.aico.aibayo.common.AnnounceTypeEnum;
import lombok.*;

import java.time.LocalDateTime;

import static com.aico.aibayo.common.AnnounceTypeEnum.*;

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
    private Long kinderNo;

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
                LocalDateTime boardRegDate, Long kinderNo, Integer roleNo, Long id, String name){
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
                    this.kinderNo=kinderNo;
                    this.roleNo=roleNo;
                    this.id=id;
                    this.name=name;
    }

}
