package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_no")
    private Long requestNo;
    @Column(name = "kid_no")
    private Long kidNo;
    @Column(name = "discount_no")
    private Long discountNo;
    @Column(name = "category_no")
    private Integer categoryNo;
    @Column(name = "payment_price")
    private Integer paymentPrice;
    @Column(name = "category_type")
    private Integer categoryType;
    @Column(name = "payment_status")
    private Integer paymentStatus;
    @Column(name = "payment_pay_date")
    private LocalDateTime paymentPayDate;
    @Column(name = "payment_start_date")
    private LocalDateTime paymentStartDate;
    @Column(name = "payment_end_date")
    private LocalDateTime paymentEndDate;
    @Column(name = "payment_memo")
    private String paymentMemo;
}
