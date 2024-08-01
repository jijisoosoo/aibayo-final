package com.aico.aibayo.dto.member;

import java.time.LocalDateTime;

import com.aico.aibayo.entity.MemberEntity;
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
    private String username;
    private String name;
    private String password;
    private String phone;
    private int roleNo;
    private String role;
    private int status;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private LocalDateTime inactivateDate;
    private LocalDateTime latestLogDate;
    private String profilePicture;
    private Long kinderNo;

    private String isMainParent;

    public MemberDto(Long id, String username, String name, String password, String phone, Integer roleNo,
                     Integer status, LocalDateTime regDate, LocalDateTime modifyDate, LocalDateTime inactivateDate,
                     LocalDateTime latestLogDate, String profilePicture, Long kinderNo) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.roleNo = roleNo;
        this.status = status;
        this.regDate = regDate;
        this.modifyDate = modifyDate;
        this.inactivateDate = inactivateDate;
        this.latestLogDate = latestLogDate;
        this.profilePicture = profilePicture;
        this.kinderNo = kinderNo;
    }

    public static MemberDto toDto(MemberEntity entity) {
        return new MemberDto(
                entity.getId(),
                entity.getUsername(),
                entity.getName(),
                entity.getPassword(),
                entity.getPhone(),
                entity.getRoleNo(),
                entity.getStatus(),
                entity.getRegDate(),
                entity.getModifyDate(),
                entity.getInactivateDate(),
                entity.getLatestLogDate(),
                entity.getProfilePicture(),
                entity.getKinderNo()
        );
    }

}
