package com.aico.aibayo.repository;

import com.aico.aibayo.entity.ParentKidEntity;
import com.aico.aibayo.entity.ParentKidId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentKidRepository extends JpaRepository<ParentKidEntity, ParentKidId> {
    ParentKidEntity findById(Long id);
}
