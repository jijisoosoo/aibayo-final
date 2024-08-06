package com.aico.aibayo.service.classManage;

import com.aico.aibayo.dto.ClassDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ClassService {
    List<ClassDto> getByKinderNo(Long kinderNo);
    List<ClassDto> getByMemberId(Long id);
    List<ClassDto> getAllByKidNo(Long kidNo);
    List<ClassDto> getClassByTeacherId(Long id);
//    List<ClassDto> getAddableClassByTeacherId(Long id);

    List<ClassDto> getAddableClassByTeacherId(Long id, List<ClassDto> assignedClasses);
}
