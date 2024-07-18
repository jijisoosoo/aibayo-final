package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "announce")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@ToString

public class AnnounceEntity {
    @Id
    @Column(name="announce_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announceNo;
    @Column(name="board_no")
    private int boardNo;
    @Column(name="announce_type")
    private int announceType;
    @Column(name="can_comment")
    private String canComment;
    @Column(name="announce_primary")
    private String announcePrimary;
}
