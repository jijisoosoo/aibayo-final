package com.aico.aibayo.service.teacher;

import com.aico.aibayo.dto.teacher.TeacherSearchCondition;
import com.aico.aibayo.dto.teacher.teacherDto;
import com.querydsl.core.Tuple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface teacherService {
    public List<teacherDto> getAllByKinderNo(TeacherSearchCondition condition);
    public List<teacherDto> getAcceptedTeacherByKinderNoAndClassNo(TeacherSearchCondition condition);
}
