package com.aico.aibayo.service.settingKinder;

import com.aico.aibayo.entity.RegisterKinderEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface SettingKinderService {

    List<RegisterKinderEntity> getAllKinder();

    Optional<RegisterKinderEntity> getKinderById(Long kinderNo);

    void insertKinder(RegisterKinderEntity kinder);

    void updateKinder(RegisterKinderEntity kinder);

    void deleteKinder(Long kinderNo);
}
