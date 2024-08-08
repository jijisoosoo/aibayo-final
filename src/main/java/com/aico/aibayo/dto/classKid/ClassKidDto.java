package com.aico.aibayo.dto.classKid;


import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString
public class ClassKidDto {
    private Long classNo;
    private Long kidNo;
    private Long acceptNo;
}
