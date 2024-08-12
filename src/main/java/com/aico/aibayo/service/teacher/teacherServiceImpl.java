package com.aico.aibayo.service.teacher;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.AcceptTypeEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.dto.teacher.TeacherSearchCondition;
import com.aico.aibayo.dto.teacher.TeacherDto;
import com.aico.aibayo.entity.AcceptLogEntity;
import com.aico.aibayo.entity.ClassTeacherEntity;
import com.aico.aibayo.repository.AcceptLogRepository;
import com.aico.aibayo.repository.ClassTeacher.ClassTeacherRepository;
import com.aico.aibayo.repository.teacher.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class teacherServiceImpl implements teacherService{
    private final TeacherRepository teacherRepository;
    private final AcceptLogRepository acceptLogRepository;
    private final ClassTeacherRepository classTeacherRepository;

    @Override
    public List<TeacherDto> getAllByKinderNo(TeacherSearchCondition condition) {
        return teacherRepository.findAllByKinderNo(condition);
    }

    @Override
    public List<TeacherDto> getAcceptedTeacherByKinderNoAndClassNo(TeacherSearchCondition condition) {
        return teacherRepository.findAcceptedTeacherByKinderNoAndClassNo(condition);
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        return teacherRepository.findTeacherById(id);
    }

    @Override
    @Transactional
    public void updateClassTeacher(List<Long> newClassIds, List<Long> oldClassAcceptNos, Long id) {
        for(Long newClassId : newClassIds) {
            // 승인이력 insert
            AcceptLogEntity acceptLogEntity = AcceptLogEntity.builder()
                    .acceptType(AcceptTypeEnum.CLASS_TEACHER.getType())
                    .acceptStatus(AcceptStatusEnum.ACCEPT.getStatus())
                    .acceptDate(LocalDateTime.now())
                    .acceptRegDate(LocalDateTime.now())
                    .acceptDeleteFlag(BooleanEnum.FALSE.getBool())
                    .build();
            AcceptLogEntity saved = acceptLogRepository.save(acceptLogEntity);

            // 새로운 반_선생 insert
            ClassTeacherEntity classTeacherEntity = ClassTeacherEntity.builder()
                    .classNo(newClassId)
                    .classTeacherId(id)
                    .acceptNo(saved.getAcceptNo())
                    .build();
            classTeacherRepository.save(classTeacherEntity);
        }

        // 사라질 반_선생 update
        for(Long oldClassAcceptNo : oldClassAcceptNos){
            acceptLogRepository.findById(oldClassAcceptNo).ifPresent(acceptLogEntity -> {
                acceptLogEntity.setAcceptStatus(AcceptStatusEnum.DELETE.getStatus());
                acceptLogEntity.setAcceptDeleteDate(LocalDateTime.now());
                acceptLogEntity.setAcceptDeleteFlag(BooleanEnum.TRUE.getBool());
            });
        }
    }

    @Override
    public KidDto deleteTeacher(TeacherDto teacherDto) {
        return null;
    }
}
