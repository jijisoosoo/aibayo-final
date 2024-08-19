package com.aico.aibayo.dto.payment;

import com.aico.aibayo.dto.schedule.ScheduleClassDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class paymentDto {
    private Long billNo;
    private Long kidNo;
    private Long kinderNo;
    private Long discountRate;
    private String paymentTitle;
    private Long paymentPrice;
    private LocalDateTime paymentStartDate;
    private LocalDateTime paymentEndDate;
    private String paymentMemo;

    private Long paymentStatus;
    private LocalDateTime paymentLogRegDate;

    private List<paymentLogDto> paymentLogs;
}
