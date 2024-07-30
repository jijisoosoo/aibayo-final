package com.aico.aibayo.dto.member;

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


    private String isMainParent;

    public MemberDto(Long id, String email, String name, String pw, String phone, Integer regType, Integer roleNo,
                     Integer status, LocalDateTime regDate, LocalDateTime modifyDate, LocalDateTime inactivateDate,
                     LocalDateTime latestLogDate, String latestIp, String profilePicture, Long kinderNo) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.pw = pw;
        this.phone = phone;
        this.regType = regType;
        this.roleNo = roleNo;
        this.status = status;
        this.regDate = regDate;
        this.modifyDate = modifyDate;
        this.inactivateDate = inactivateDate;
        this.latestLogDate = latestLogDate;
        this.latestIp = latestIp;
        this.profilePicture = profilePicture;
        this.kinderNo = kinderNo;
    }

}
