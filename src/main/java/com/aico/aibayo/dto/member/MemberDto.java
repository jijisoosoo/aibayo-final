package com.aico.aibayo.dto.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String username; // email
    private String name;
    private String role;
    private String password;
    private String phone;

}
