package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_no")
    private String boardNo;
    @Column(name = "invisible_flag")
    private String invisibleFlag;
    @Column
    private String writer;
    @Column(name = "board_title")
    private String boardTitle;
    @Column(name = "board_contents")
    private String board_Contents;
}
