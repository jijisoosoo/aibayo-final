package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_discount")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PaymentDiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_no")
    private Long discountNo;
    @Column(name = "discount_type")
    private Integer discountType;
    @Column(name = "discount_rate")
    private Integer discountRate;
}
