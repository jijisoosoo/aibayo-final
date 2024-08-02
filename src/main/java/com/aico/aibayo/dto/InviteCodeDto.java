package com.aico.aibayo.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InviteCodeDto {
    private Long inviteId;
    private Long acceptNo;
    private Integer inviteType;
    private String inviteEmail;
    private LocalDate inviteRegDate;
    private LocalDate inviteExpireDate;
    private String inviteExpireFlag;
    private Long kinderNo;
    private Long kidNo;
    private Long inviteName;
}
