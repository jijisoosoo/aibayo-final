package com.aico.aibayo.service.teacher;

import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.dto.teacher.TeacherSearchCondition;
import com.aico.aibayo.dto.teacher.TeacherDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface teacherService {
    List<TeacherDto> getAllByKinderNo(TeacherSearchCondition condition);
    List<TeacherDto> getAcceptedTeacherByKinderNoAndClassNo(TeacherSearchCondition condition);
    TeacherDto getTeacherById(Long id);
    void updateClassTeacher(List<Long> newClassIds, List<Long> oldClassAcceptNos, Long id);
    KidDto deleteTeacher(TeacherDto teacherDto);
}
