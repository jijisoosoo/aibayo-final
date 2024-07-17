package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PaymentDiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "discount_no")
    private int discountNo;
    @Column(name = "discount_type")
    private int discountType;
    @Column(name = "discount_rate")
    private int discountRate;
}
