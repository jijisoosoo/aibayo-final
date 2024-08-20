package com.aico.aibayo.repository.parentKid;

import com.aico.aibayo.entity.ParentKidEntity;
import com.aico.aibayo.entity.ParentKidId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentKidRepository extends JpaRepository<ParentKidEntity, ParentKidId>, ParentKidRepositoryCustom {
    ParentKidEntity findById(Long id);
}
