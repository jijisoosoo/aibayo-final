package com.aico.aibayo.repository.kid;

import com.aico.aibayo.entity.KidEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KidRepository extends JpaRepository<KidEntity, Long>, KidRepositoryCustom {
    List<KidEntity> findAllByKinderNoAndDischargeFlagEquals(Long kinderNo, String dischargeFlag);
}
