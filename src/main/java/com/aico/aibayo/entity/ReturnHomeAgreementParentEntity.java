package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "return_home_agreement_parent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReturnHomeAgreementParentEntity {
    @Id
    @Column(name="rh_agree_parent_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rhAgreeParentNo; //귀가 동의 보호자 번호
    @Column(name="rh_agree_no")
    private Integer rhAgreeNo; //귀가 동의 번호 0:주보호자 1:부보호자
    @Column(name="rh_agree_parent_type")
    private Integer rhAgreeParentType; //귀가 동의 보호자 분류
    @Column(name="rh_agree_parent_name")
    private String rhAgreeParentName; //귀가 동의 보호자명
    @Column(name="rh_agree_parent_tel")
    private String rhAgreeParentTel; //귀가 동의 연락처
}
