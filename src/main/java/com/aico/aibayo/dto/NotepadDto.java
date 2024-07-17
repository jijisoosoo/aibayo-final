package com.aico.aibayo.dto;

import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NotepadDto {
    private Long notepadNo;
    private Long boardNo;
    private int weather;
    private String hasLifeRecord;
}
