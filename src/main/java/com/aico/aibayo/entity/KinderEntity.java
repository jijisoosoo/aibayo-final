package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "kinder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class KinderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kinder_no")
    private Long kinderNo; // 유치원 번호

    @Column(name = "kinder_open_time")
    private LocalTime kinderOpenTime; // 유치원 등원시간

    @Column(name = "kinder_close_time")
    private LocalTime kinderCloseTime; // 유치원 하원시간

    @Column(name = "kinder_name")
    private String kinderName; // 유치원 이름

    @Column(name = "kinder_post_code")
    private String kinderPostCode; //유치원 우편번호

    @Column(name = "kinder_tel")
    private String kinderTel; //유치원 전화번호

    @Column(name = "kinder_addr")
    private String kinderAddr; //유치원 주소

    @Column(name = "principal_name")
    private String principalName; //원장님 이름


    @Column(name = "kinder_reg_date")
    private LocalDateTime kinderRegDate; // 유치원 등록일자

    @Column(name = "kinder_modify_date")
    private LocalDateTime kinderModifyDate; // 유치원 수정일자

    @Column(name = "kinder_delete_date")
    private LocalDateTime kinderDeleteDate; // 유치원 삭제일자

    @Column(name = "sido_list")
    private String sidoList; // API 시도 리스트

    @Column(name = "sgg_list")
    private String sggList; // API 시군구 리스트
}
