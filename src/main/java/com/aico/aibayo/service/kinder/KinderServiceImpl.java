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
                .kinderOpenTime(kinderDto.getKinderOpenTime())
                .kinderCloseTime(kinderDto.getKinderCloseTime())
                .kinderName(kinderDto.getKinderName())
                .principalName(kinderDto.getPrincipalName())
                .kinderPostCode(kinderDto.getKinderPostCode())
                .kinderTel(kinderDto.getKinderTel())
                .kinderAddr(kinderDto.getKinderAddr())
                .kinderRegDate(LocalDateTime.now())
                .sidoList(kinderDto.getSidoList())
                .sggList(kinderDto.getSggList())
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
    public void updateKinder(KinderDto kinderDto) {

    }

    @Override
    public void deleteKinder(Long kinderNo) {

    }
}
