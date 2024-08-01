package com.aico.aibayo.repository.classManage;

import com.aico.aibayo.dto.ClassDto;
import java.util.List;

public interface ClassRepositoryCustom {
    List<ClassDto> findAllByMemberId(Long id);
    List<ClassDto> findAllByKidNo(Long kidNo);
}
