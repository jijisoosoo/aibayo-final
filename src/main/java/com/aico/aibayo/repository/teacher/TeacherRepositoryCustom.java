package com.aico.aibayo.repository.teacher;

import com.aico.aibayo.dto.teacher.teacherDto;
import com.aico.aibayo.dto.teacher.TeacherSearchCondition;

import java.util.List;

public interface TeacherRepositoryCustom {

    List<teacherDto> findAllByKinderNo(Long kinderNo);
//    List<teacherDto> findAllByKinderNo(TeacherSearchCondition condition, Long kinderNo);


}
