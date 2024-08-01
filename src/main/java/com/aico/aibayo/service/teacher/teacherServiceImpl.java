package com.aico.aibayo.service.teacher;

import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.teacher.teacherDto;
import com.aico.aibayo.repository.teacher.TeacherRepository;
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
    public List<MemberDto> getAllByKinderNo(Long kinderNo) {return teacherRepository.findAllByKinderNo(kinderNo);}
}
