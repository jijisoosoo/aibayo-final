package com.aico.aibayo.service.teacher;

import com.aico.aibayo.dto.teacher.teacherDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface teacherService {
    public List<teacherDto> getAllByKinderNo(Long kinderNo);
}
