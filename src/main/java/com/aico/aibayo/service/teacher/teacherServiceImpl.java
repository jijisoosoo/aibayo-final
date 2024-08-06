package com.aico.aibayo.service.teacher;

import com.aico.aibayo.dto.teacher.TeacherSearchCondition;
import com.aico.aibayo.dto.teacher.teacherDto;
import com.aico.aibayo.repository.teacher.TeacherRepository;
import com.aico.aibayo.repository.teacher.TeacherRepositoryCustom;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class teacherServiceImpl implements teacherService{
    private final TeacherRepository teacherRepository;

    @Override
    public List<teacherDto> getAllByKinderNo(TeacherSearchCondition condition) {
        return teacherRepository.findAllByKinderNo(condition);
    }

    @Override
    public List<teacherDto> getAcceptedTeacherByKinderNoAndClassNo(TeacherSearchCondition condition) {
        return teacherRepository.findAcceptedTeacherByKinderNoAndClassNo(condition);
    }

    @Override
    public teacherDto getTeacherById(Long id) {
        return teacherRepository.findTeacherById(id);
    }
}
