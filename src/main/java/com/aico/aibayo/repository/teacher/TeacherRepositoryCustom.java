package com.aico.aibayo.repository.teacher;

import com.aico.aibayo.dto.teacher.teacherDto;

import java.util.List;

public interface TeacherRepositoryCustom {

    List<teacherDto> findAllByKinderNo(Long kinderNo);

}
