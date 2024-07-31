package com.aico.aibayo.dto;

import com.aico.aibayo.entity.ClassEntity;
import com.aico.aibayo.entity.MemberEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.*;

import java.time.LocalDateTime;

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
    private int regType;
    private int roleNo;
    private int status;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private LocalDateTime inactivateDate;
    private LocalDateTime latestLogDate;
    private String latestIp;
    private String profilePicture;
    private Long kinderNo;

    public static MemberDto toDto(MemberEntity entity) {
        return new MemberDto(
                entity.getId(),
                entity.getEmail(),
                entity.getName(),
                entity.getPw(),
                entity.getPhone(),
                entity.getRegType(),
                entity.getRoleNo(),
                entity.getStatus(),
                entity.getRegDate(),
                entity.getModifyDate(),
                entity.getInactivateDate(),
                entity.getLatestLogDate(),
                entity.getLatestIp(),
                entity.getProfilePicture(),
                entity.getKinderNo()
        );
    }
}
