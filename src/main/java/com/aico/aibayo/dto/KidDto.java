package com.aico.aibayo.dto;

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
