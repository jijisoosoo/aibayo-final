package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "return_home_agreement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class medicationPicEntity {
    @Id
    @Column(name="medi_order_no")
    private Long mediOrderNo; // 투약 의뢰번호
    @Column(name="medi_pic")
    private String mediPic; //투약 사진
    @Column(name="medi_pic_desc")
    private String mediPicDesc; //투약 사진 설명
}
