package com.aico.aibayo.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String name;
    private String pw;
    private String phone;
    private Integer regType;
    private Integer roleNo;
    private Integer status;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private LocalDateTime inactivateDate;
    private LocalDateTime latestLogDate;
    private String latestIp;
    private String profilePicture;
    private Long kinderNo;
}
