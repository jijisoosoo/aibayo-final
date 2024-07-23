package com.aico.aibayo.service.kid;

import com.aico.aibayo.dto.KidDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface KidService {
    List<KidDto> getByKinderNo(Long kinderNo);
    List<KidDto> getByMemberId(Long id);
}
