package com.aico.aibayo.service.teacher;

import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.dto.teacher.TeacherSearchCondition;
import com.aico.aibayo.dto.teacher.teacherDto;
import com.querydsl.core.Tuple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface teacherService {
    List<teacherDto> getAllByKinderNo(TeacherSearchCondition condition);
    List<teacherDto> getAcceptedTeacherByKinderNoAndClassNo(TeacherSearchCondition condition);
    teacherDto getTeacherById(Long id);

    void assignNewClass(List<Long> newClassIds, Long id);
    void deleteExistingClass(List<Long> oldClassIds, Long id);
}
