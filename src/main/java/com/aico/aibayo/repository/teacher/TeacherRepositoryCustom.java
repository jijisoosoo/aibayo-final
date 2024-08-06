package com.aico.aibayo.repository.teacher;

import com.aico.aibayo.dto.teacher.TeacherSearchCondition;
import com.aico.aibayo.dto.teacher.teacherDto;

import java.util.List;

public interface TeacherRepositoryCustom {

    List<teacherDto> findAllByKinderNo(TeacherSearchCondition condition);
    List<teacherDto> findAcceptedTeacherByKinderNoAndClassNo(TeacherSearchCondition condition);
    teacherDto findTeacherById(Long id);
}
