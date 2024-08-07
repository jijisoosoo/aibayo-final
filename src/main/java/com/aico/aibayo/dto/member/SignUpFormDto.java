package com.aico.aibayo.dto.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SignUpFormDto {
    private String username;
    private String password;
    private String phone;
    private String name;
    private String role;
}
