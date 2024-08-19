package com.aico.aibayo.repository.payment;

import com.aico.aibayo.dto.payment.PaymentDto;
import com.aico.aibayo.dto.payment.PaymentSearchCondition;
import com.aico.aibayo.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PaymentRepositoryCustomImpl implements PaymentRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private final QPaymentEntity payment = QPaymentEntity.paymentEntity;
    private final QPaymentLogEntity paymentLog = QPaymentLogEntity.paymentLogEntity;
    private final QKidEntity kid = QKidEntity.kidEntity;
    private final QClassEntity clazz = QClassEntity.classEntity;

    @Override
    public List<PaymentDto> findAllByKinderNo(PaymentSearchCondition condition) {
        List<PaymentDto> paymentDtoList = jpaQueryFactory
                .select(Projections.constructor(PaymentDto.class,
                        payment.billNo,
                        payment.kidNo,
                        payment.classNo,
                        payment.discountRate,
                        payment.paymentTitle,
                        payment.paymentPrice,
                        payment.paymentStartDate,
                        payment.paymentEndDate,
                        payment.paymentMemo,
                        paymentLog.paymentStatus,
                        paymentLog.paymentLogRegDate,
                        kid.kidName,
                        clazz.className))
                .from(payment)
                .join(paymentLog).on(payment.billNo.eq(paymentLog.billNo))
                .join(kid).on(payment.kidNo.eq(kid.kidNo))
                .join(clazz).on(payment.classNo.eq(clazz.classNo))
                .where(payment.kinderNo.eq(condition.getKinderNo()))
                .fetch();

        return paymentDtoList;
    }
}
