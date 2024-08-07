package com.aico.aibayo.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SignUpFinalFormDto {
    private String username;
    private String password;
    private String phone;
    private String name;
    private String role;
    private LocalDate kidBirth;
    private String kidGender; // 1:남자, 2:여자
    private Long kinderNo;
    private Long ClassNo;
    private String kidName;
    private String relationship;
}
