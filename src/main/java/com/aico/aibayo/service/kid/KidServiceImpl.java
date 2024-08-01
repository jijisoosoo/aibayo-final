package com.aico.aibayo.service.kid;

import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.dto.kid.KidSearchCondition;
import com.aico.aibayo.entity.KidEntity;
import com.aico.aibayo.repository.kid.KidRepository;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KidServiceImpl implements KidService {
    private final KidRepository kidRepository;

    @Override
    public List<KidDto> getByKinderNo(Long kinderNo) {
        List<KidEntity> kidEntities =
                kidRepository.findAllByKinderNoAndDischargeFlagEquals(kinderNo, BooleanEnum.FALSE.getBool());

        return kidEntities.stream()
                          .map(KidDto :: toDto)
                          .collect(Collectors.toList());
    }

    @Override
    public List<KidDto> getByMemberId(Long id) {
        return kidRepository.findAllByMemberId(id);
    }

    @Override
    public List<KidDto> getAllByClassNoAndAcceptStatus(KidSearchCondition condition) {
        return kidRepository.findAllByClassNoAndAcceptStatus(condition);
    }

    @Override
    public List<KidDto> getAllWithParentByClassNoAndAcceptStatus(KidSearchCondition condition) {
        return kidRepository.findAllWithParentByClassNoAndAcceptStatus(condition);
    }

    @Override
    public KidDto getByKidNo(Long kidNo) {
        return KidDto.toDto(Objects.requireNonNull(kidRepository.findById(kidNo).orElse(null)));
    }
}
