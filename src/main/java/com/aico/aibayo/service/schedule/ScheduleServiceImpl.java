package com.aico.aibayo.service.schedule;

import com.aico.aibayo.common.BoardTypeEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.schedule.ScheduleDto;
import com.aico.aibayo.dto.schedule.ScheduleSearchCondition;
import com.aico.aibayo.entity.BoardEntity;
import com.aico.aibayo.entity.ScheduleClassEntity;
import com.aico.aibayo.entity.ScheduleEntity;
import com.aico.aibayo.repository.BoardRepository;
import com.aico.aibayo.repository.schedule.ScheduleClassRepository;
import com.aico.aibayo.repository.schedule.ScheduleRepository;
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
public class ScheduleServiceImpl implements ScheduleService {
    private final BoardRepository boardRepository;
    private final ScheduleRepository scheduleRepository;
    private final ScheduleClassRepository scheduleClassRepository;

    @Override
    public List<ScheduleDto> getAllByKinderNo(ScheduleSearchCondition condition) {
        return scheduleRepository.findAllByKinderNo(condition);
    }

    @Override
    public List<ScheduleDto> getListByDay(ScheduleSearchCondition condition) {
        return scheduleRepository.findListByDay(condition);
    }

    @Override
    public List<ScheduleDto> getListByClass(ScheduleSearchCondition condition) {
        return scheduleRepository.findListByClass(condition);
    }

    @Override
    @Transactional
    public void insertSchedule(Map<String, Object> requestBody) {

        Long writer = (Long)requestBody.get("writer");
        String boardTitle = (String)requestBody.get("boardTitle");
        String boardContents = (String)requestBody.get("boardContents");
        Long kinderNo = (Long)requestBody.get("kinderNo");
        LocalDateTime startDate = LocalDateTime.parse((String)(requestBody.get("startDate")));
        LocalDateTime endDate = LocalDateTime.parse((String)(requestBody.get("endDate")));

        List<?> classes = (List<?>) requestBody.get("classList");
        List<Long> classList = classes.stream()
                .map(element -> Long.parseLong(element.toString())) // String을 Long으로 변환
                .toList();

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

        ScheduleEntity scheduleEntity = ScheduleEntity.builder()
                .boardNo(savedBoard.getBoardNo())
                .scheduleStartDate(startDate)
                .scheduleEndDate(endDate)
                .build();

        ScheduleEntity savedSchedule = scheduleRepository.save(scheduleEntity);

        if(classList != null) {
            for(Long classNo : classList){
                ScheduleClassEntity scheduleClassEntity = ScheduleClassEntity.builder()
                        .scheduleNo(savedSchedule.getScheduleNo())
                        .classNo(classNo)
                        .build();
                scheduleClassRepository.save(scheduleClassEntity);
            }
        }else{
            ScheduleClassEntity scheduleClassEntity = ScheduleClassEntity.builder()
                    .scheduleNo(savedSchedule.getScheduleNo())
                    .classNo(0L)
                    .build();
            scheduleClassRepository.save(scheduleClassEntity);
        }
    }

    @Override
    public ScheduleDto getOneByScheduleNo(ScheduleSearchCondition condition) {
        return scheduleRepository.findOneByScheduleNo(condition);
    }
}
