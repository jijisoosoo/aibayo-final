package com.aico.aibayo.service.payment;

import com.aico.aibayo.dto.payment.PaymentDto;
import com.aico.aibayo.dto.payment.PaymentSearchCondition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PaymentService {
    List<PaymentDto> getAllByKinderNo(PaymentSearchCondition condition);
    List<PaymentDto> getAllBySearchCondition(PaymentSearchCondition condition);
    void insertSchedule(Map<String, Object> requestBody);
}
