package com.aico.aibayo.service.kid;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.AcceptTypeEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.dto.kid.KidSearchCondition;
import com.aico.aibayo.entity.AcceptLogEntity;
import com.aico.aibayo.entity.ClassKidEntity;
import com.aico.aibayo.entity.KidEntity;
import com.aico.aibayo.repository.AcceptLogRepository;
import com.aico.aibayo.repository.ClassKidRepository;
import com.aico.aibayo.repository.kid.KidRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class KidServiceImpl implements KidService {
    private final KidRepository kidRepository;
    private final ClassKidRepository classKidRepository;
    private final AcceptLogRepository acceptLogRepository;

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

    @Override
    public KidDto updateKid(KidDto kidDto) {
        KidEntity target = kidRepository.findById(kidDto.getKidNo()).orElse(null);

        if (target == null) { return null; }

        // 원생 기본정보 업데이트
        if (kidDto.getKidName() != null) { target.setKidName(kidDto.getKidName()); }
        if (kidDto.getKidBirth() != null) { target.setKidBirth(kidDto.getKidBirth()); }

        target.setModifyDate(LocalDateTime.now());

        return KidDto.toDto(kidRepository.save(target));
    }

    @Override
    @Transactional
    public void updateKidRelation(KidDto kidDto) {
        // 반_원생 관계 업데이트
        // 1. 승인이력 insert
        // 2. 반_원생 insert
        if (kidDto.getClassNo() != null) {
            AcceptLogEntity acceptLogEntity = AcceptLogEntity.builder()
                    .acceptType(AcceptTypeEnum.CLASS_KID.getType())
                    .acceptStatus(AcceptStatusEnum.ACCEPT.getStatus())
                    .acceptDate(LocalDateTime.now())
                    .acceptRegDate(LocalDateTime.now())
                    .acceptDeleteFlag(BooleanEnum.FALSE.getBool())
                    .build();
            AcceptLogEntity saved = acceptLogRepository.save(acceptLogEntity);

            ClassKidEntity classKidEntity = ClassKidEntity.builder()
                    .classNo(kidDto.getClassNo())
                    .kidNo(kidDto.getKidNo())
                    .acceptNo(saved.getAcceptNo())
                    .build();

            classKidRepository.save(classKidEntity);
        }
    }
}
