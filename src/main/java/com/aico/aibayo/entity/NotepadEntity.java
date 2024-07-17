package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "notepad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NotepadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notepad_no")
    private Long notepadNo;
    @Column(name = "board_no")
    private Long boardNo;
    @Column()
    @ColumnDefault("-1")
    private int weather;
    @Column(name = "has_life_record")
    private String hasLifeRecord;
}
