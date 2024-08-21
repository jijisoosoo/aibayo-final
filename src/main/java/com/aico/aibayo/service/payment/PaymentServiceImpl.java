package com.aico.aibayo.service.payment;

import com.aico.aibayo.common.BoardTypeEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.payment.PaymentDto;
import com.aico.aibayo.dto.payment.PaymentSearchCondition;
import com.aico.aibayo.entity.BoardEntity;
import com.aico.aibayo.entity.ScheduleClassEntity;
import com.aico.aibayo.entity.ScheduleEntity;
import com.aico.aibayo.repository.payment.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public List<PaymentDto> getAllByKinderNo(PaymentSearchCondition condition) {
        return paymentRepository.findAllByKinderNo(condition);
    }

    @Override
    public List<PaymentDto> getAllBySearchCondition(PaymentSearchCondition condition) {
        return paymentRepository.findAllBySearchCondition(condition);
    }

    @Override
    @Transactional
    public void insertSchedule(Map<String, Object> requestBody) {
        let id = $(this).attr('id');
        let kidNo = $(this).find('.kidNameBox').attr('id');
        let classNo = $('.selectedClassName').attr('value');
        let paymentTitle = $('#paymentTitle').val();
        let discountRate = getDiscount(kidNo);
        let paymentPrice = price;
        let paymentEndDate = ($('.datepicker').val() + 'T' + $('.timepicker').val()).replace(/\./g, '-');
        let paymentMemo = getMemo(kidNo);
        let kinderNo = null;



        Long kinderNo = (Long)requestBody.get("kinderNo");

        List<?> payments = (List<?>) requestBody.get("classList");
        List<PaymentDto> paymentList = payments.stream()
                .map(element -> Long.parseLong(element.toString())) // String을 Long으로 변환
                .toList();




        // board insert
        BoardEntity boardEntity = BoardEntity.builder()
                .invisibleFlag(BooleanEnum.FALSE.getBool())
                .boardType(BoardTypeEnum.SCHEDULE.getNum())
                .writer(writer)
                .boardTitle(boardTitle)
                .boardContents(boardContents)
                .boardRegDate(LocalDateTime.now())
                .kinderNo(kinderNo)
                .build();

        BoardEntity savedBoard = boardRepository.save(boardEntity);

        // schedule insert
        ScheduleEntity scheduleEntity = ScheduleEntity.builder()
                .boardNo(savedBoard.getBoardNo())
                .scheduleStartDate(startDate)
                .scheduleEndDate(endDate)
                .mapLat(mapLat)
                .mapLng(mapLng)
                .build();

        ScheduleEntity savedSchedule = scheduleRepository.save(scheduleEntity);

        // scheduleClass insert
        for(Long classNo : classList) {
            ScheduleClassEntity scheduleClassEntity = ScheduleClassEntity.builder()
                    .scheduleNo(savedSchedule.getScheduleNo())
                    .classNo(classNo)
                    .build();
            scheduleClassRepository.save(scheduleClassEntity);
        }
    }
}
