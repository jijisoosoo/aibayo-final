package com.aico.aibayo.service.kinder;

import com.aico.aibayo.dto.kinder.KinderDto;
import com.aico.aibayo.entity.RegisterKinderEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface KinderService {

    Optional<RegisterKinderEntity> findByKinderNo(Long kinderNo);

    List<RegisterKinderEntity> getAllKinder();

    Optional<RegisterKinderEntity> getKinderById(Long kinderNo);

    void insertKinder(KinderDto kinderDto);

    void updateKinder(KinderDto kinderDto);

    void deleteKinder(Long kinderNo);
}
