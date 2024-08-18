package com.aico.aibayo.service.kinder;

import com.aico.aibayo.dto.comment.CommentDto;
import com.aico.aibayo.dto.kinder.KinderDto;
import com.aico.aibayo.entity.KinderEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface KinderService {

    List<KinderEntity> getAllKinder();

    Optional<KinderEntity> getKinderById(Long kinderNo);

    void insertKinder(KinderDto kinderDto);

    void updateKinder(KinderDto kinderDto);

    void deleteKinder(Long kinderNo);
}
