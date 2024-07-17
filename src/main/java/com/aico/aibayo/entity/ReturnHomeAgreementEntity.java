package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "return_home_agreement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class ReturnHomeAgreementEntity {
    @Id
    @Column(name="rh_agree_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rhAgreeNo; //귀가 동의 번호
    @Column(name="order_no")
    private int orderNo; //의뢰 번호
    @Column(name="rh_time")
    private LocalDateTime rhTime; //귀가 시간
    @Column(name="rh_type")
    private String rhType; //귀가 방법
}
