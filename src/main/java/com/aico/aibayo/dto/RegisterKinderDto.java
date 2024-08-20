package com.aico.aibayo.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.aico.aibayo.entity.RegisterKinderEntity;
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
public class RegisterKinderDto {
    private Long kinderNo; // 유치원 번호
    private LocalTime kinderOpenTime; // 유치원 등원시간
    private LocalTime kinderCloseTime; // 유치원 하원시간
    private String kinderName; // 유치원 이름
    private String kinderPostCode; //유치원 우편번호
    private String kinderLocNo; //유치원 지역 번호
    private String kinderMidNo;
    private String kinderEndNo;
    private String kinderAddr; //유치원 주소
    private String kinderAddrDetail; //유치원 주소
    private LocalDateTime kinderRegDate; // 유치원 등록일자
    private LocalDateTime kinderModifyDate; // 유치원 수정일자
    private LocalDateTime kinderDeleteDate; // 유치원 삭제일자
    private String sidoList; // API 시도 리스트
    private String sggList; // API 시군구 리스트
    private String deleteFlag;


    public static RegisterKinderDto toDto(RegisterKinderEntity entity) {
        return new RegisterKinderDto(
                entity.getKinderNo(),
                entity.getKinderOpenTime(),
                entity.getKinderCloseTime(),
                entity.getKinderName(),
                entity.getKinderPostCode(),
                entity.getKinderLocNo(),
                entity.getKinderMidNo(),
                entity.getKinderEndNo(),
                entity.getKinderAddr(),
                entity.getKinderAddrDetail(),
                entity.getKinderRegDate(),
                entity.getKinderModifyDate(),
                entity.getKinderDeleteDate(),
                entity.getSidoList(),
                entity.getSggList(),
                entity.getDeleteFlag()
        );
    }
}
