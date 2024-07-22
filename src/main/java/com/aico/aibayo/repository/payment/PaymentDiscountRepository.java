package com.aico.aibayo.repository.payment;

import com.aico.aibayo.entity.PaymentDiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDiscountRepository extends JpaRepository<PaymentDiscountEntity, Long> {
}
