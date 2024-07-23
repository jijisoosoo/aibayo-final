package com.aico.aibayo.repository.kid;

import com.aico.aibayo.dto.KidDto;
import java.util.List;

public interface KidRepositoryCustom {
    List<KidDto> findAllByMemberId(Long id);
}
