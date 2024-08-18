package com.aico.aibayo.service.settingKinder;

import com.aico.aibayo.entity.RegisterKinderEntity;
import com.aico.aibayo.repository.settingKinder.SettingKinderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SettingKinderServiceImpl implements SettingKinderService {
    private final SettingKinderRepository settingKinderRepository;
    @Override
    public List<RegisterKinderEntity> getAllKinder() {
       return settingKinderRepository.findAll();
    }

    @Override
    public Optional<RegisterKinderEntity> getKinderById(Long kinderNo) {
        return settingKinderRepository.findById(kinderNo);

    }

    @Override
    public void insertKinder(RegisterKinderEntity kinder) {
        settingKinderRepository.save(kinder);
    }

    @Override
    public void updateKinder(RegisterKinderEntity kinder) {
        RegisterKinderEntity registerKinderEntity =
                settingKinderRepository.findById(kinder.getKinderNo()).get();
        assert registerKinderEntity != null;


    }

    @Override
    public void deleteKinder(Long kinderNo) {

    }
}
