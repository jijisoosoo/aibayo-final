package com.aico.aibayo.repository.teacher;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.teacher.teacherDto;
import com.aico.aibayo.dto.teacher.TeacherSearchCondition;

import java.util.List;

public interface TeacherRepositoryCustom {

    List<MemberDto> findAllByKinderNo(Long kinderNo);
//    List<teacherDto> findAllByKinderNo(TeacherSearchCondition condition, Long kinderNo);


}
