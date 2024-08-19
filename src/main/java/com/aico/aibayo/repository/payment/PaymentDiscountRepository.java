package com.aico.aibayo.repository.payment;

import com.aico.aibayo.entity.PaymentLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDiscountRepository extends JpaRepository<PaymentLogEntity, Long> {
}
