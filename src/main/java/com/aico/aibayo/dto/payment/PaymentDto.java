package com.aico.aibayo.dto.payment;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
    private Long billNo;
    private Long kidNo;
    private Long classNo;
    private Long kinderNo;
    private Long discountRate;
    private String paymentTitle;
    private Long paymentPrice;
    private LocalDateTime paymentStartDate;
    private LocalDateTime paymentEndDate;
    private String paymentMemo;

    private Integer paymentStatus;
    private LocalDateTime paymentLogRegDate;

    private String kidName;
    private String className;

    private List<PaymentLogDto> paymentLogs;

    public PaymentDto(Long billNo, Long kidNo, Long classNo, Long discountRate,
                       String paymentTitle, Long paymentPrice,
                       LocalDateTime paymentStartDate, LocalDateTime paymentEndDate,
                      String paymentMemo, Integer paymentStatus, LocalDateTime paymentLogRegDate,
                      String kidName, String className){
        this.billNo = billNo;
        this.kidNo = kidNo;
        this.classNo = classNo;
        this.discountRate = discountRate;
        this.paymentTitle = paymentTitle;
        this.paymentPrice = paymentPrice;
        this.paymentStartDate = paymentStartDate;
        this.paymentEndDate = paymentEndDate;
        this.paymentMemo = paymentMemo;
        this.paymentStatus = paymentStatus;
        this.paymentLogRegDate = paymentLogRegDate;
        this.kidName = kidName;
        this.className = className;
    }


}
