package com.aico.aibayo.service.classManage;

import com.aico.aibayo.dto.ClassDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ClassService {
    List<ClassDto> getByKinderNo(Long kinderNo);
    List<ClassDto> getByMemberId(Long id);
    List<ClassDto> getAllByKidNo(Long kidNo);

    List<ClassDto> getAllByKinderNo(Long kinderNo);
    List<ClassDto> getAddableClassByKinderNo(Long kinderNo);
    List<ClassDto> getClassByKinderNoAndTeacherId(Long kinderNo, Long id);

}
