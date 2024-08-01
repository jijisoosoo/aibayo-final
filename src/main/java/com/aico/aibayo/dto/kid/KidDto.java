package com.aico.aibayo.dto.kid;

import com.aico.aibayo.entity.KidEntity;
import java.time.LocalDate;
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
public class KidDto {
    private Long kidNo;
    private Long kinderNo;
    private String kidName;
    private LocalDate kidBirth;
    private Integer kidGender;
    private LocalDateTime admissionDate;
    private LocalDateTime modifyDate;
    private LocalDateTime dischargeDate;
    private String dischargeFlag;

    private String username;

    private String inviteEmail;

    public KidDto(Long kidNo, Long kinderNo, String kidName, LocalDate kidBirth, Integer kidGender,
                  LocalDateTime admissionDate, LocalDateTime modifyDate, LocalDateTime dischargeDate,
                  String dischargeFlag) {
        this.kidNo = kidNo;
        this.kinderNo = kinderNo;
        this.kidName = kidName;
        this.kidBirth = kidBirth;
        this.kidGender = kidGender;
        this.admissionDate = admissionDate;
        this.modifyDate = modifyDate;
        this.dischargeDate = dischargeDate;
        this.dischargeFlag = dischargeFlag;
    }

    public static KidDto toDto(KidEntity entity) {
        return new KidDto(
            entity.getKidNo(),
            entity.getKinderNo(),
            entity.getKidName(),
            entity.getKidBirth(),
            entity.getKidGender(),
            entity.getAdmissionDate(),
            entity.getModifyDate(),
            entity.getDischargeDate(),
            entity.getDischargeFlag()
        );
    }
}
