package com.aico.aibayo.service.kinder;

import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.kinder.KinderDto;
import com.aico.aibayo.entity.KinderEntity;
import com.aico.aibayo.entity.SettingMenuEntity;
import com.aico.aibayo.repository.settingKinder.KinderRepository;
import com.aico.aibayo.repository.settingKinder.SettingMenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class KinderServiceImpl implements KinderService {
    private final KinderRepository kinderRepository;
    private final SettingMenuRepository settingMenuRepository;

    @Override
    public Optional<KinderEntity> findByKinderNo(Long kinderNo) {
        return kinderRepository.findById(kinderNo);
    }

    @Override
    public List<KinderEntity> getAllKinder() {
        return kinderRepository.findAll();
    }

    @Override
    public Optional<KinderEntity> getKinderById(Long kinderNo) {
        return kinderRepository.findById(kinderNo);
    }

    @Override
    @Transactional
    public void insertKinder(KinderDto kinderDto) {
        KinderEntity kinderentity = KinderEntity.builder()
                .id(kinderDto.getId())
                .kinderOpenTime(kinderDto.getKinderOpenTime())
                .kinderCloseTime(kinderDto.getKinderCloseTime())
                .kinderName(kinderDto.getKinderName())
                .principalName(kinderDto.getPrincipalName())
                .kinderPostCode(kinderDto.getKinderPostCode())
                .kinderLocNo(kinderDto.getKinderLocNo())
                .kinderMidNo(kinderDto.getKinderMidNo())
                .kinderEndNo(kinderDto.getKinderEndNo())
                .kinderAddr(kinderDto.getKinderAddr())
                .kinderAddrDetail(kinderDto.getKinderAddrDetail())
                .kinderRegDate(LocalDateTime.now())
                .sidoList(kinderDto.getSidoList())
                .sggList(kinderDto.getSggList())
                .mapLat(kinderDto.getMapLat())
                .mapLng(kinderDto.getMapLng())
                .deleteFlag(BooleanEnum.FALSE.getBool())
                .build();
        KinderEntity saveKinder = kinderRepository.save(kinderentity);
        SettingMenuEntity settingMenuEntity = SettingMenuEntity.builder()
                .kinderNo(saveKinder.getKinderNo())
                .announceStatus(BooleanEnum.FALSE.getBool())
                .notepadStatus(BooleanEnum.TRUE.getBool())
                .mealStatus(BooleanEnum.TRUE.getBool())
                .medicationStatus(BooleanEnum.TRUE.getBool())
                .returnHomeStatus(BooleanEnum.TRUE.getBool())
                .attendanceStatus(BooleanEnum.TRUE.getBool())
                .scheduleStatus(BooleanEnum.TRUE.getBool())
                .pickDropStatus(BooleanEnum.TRUE.getBool())
                .lifeRecordStatus(BooleanEnum.TRUE.getBool())
                .chatStatus(BooleanEnum.TRUE.getBool())
                .build();
        SettingMenuEntity saveSettingMenu = settingMenuRepository.save(settingMenuEntity);
    }

    @Override
    @Transactional
    public void updateKinder(KinderDto kinderDto) {
        KinderEntity kinderEntity =
            kinderRepository.findById(kinderDto.getKinderNo()).orElse(null);
            assert kinderEntity != null;
            kinderEntity.setKinderPostCode(kinderDto.getKinderPostCode());
            kinderEntity.setKinderAddr(kinderDto.getKinderAddr());
            kinderEntity.setKinderAddrDetail(kinderDto.getKinderAddrDetail());
            kinderEntity.setKinderName(kinderDto.getKinderName());
            kinderEntity.setKinderLocNo(kinderDto.getKinderLocNo());
            kinderEntity.setKinderMidNo(kinderDto.getKinderMidNo());
            kinderEntity.setKinderEndNo(kinderDto.getKinderEndNo());
            kinderEntity.setKinderOpenTime(kinderDto.getKinderOpenTime());
            kinderEntity.setKinderCloseTime(kinderDto.getKinderCloseTime());

        kinderRepository.save(kinderEntity);
    }

    @Override
    public void deleteKinder(Long kinderNo) {

    }
}
