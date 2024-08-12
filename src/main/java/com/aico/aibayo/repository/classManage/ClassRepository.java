package com.aico.aibayo.repository.classManage;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.entity.ClassEntity;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Integer>, ClassRepositoryCustom {
    List<ClassEntity> findAllByKinderNoAndClassDeleteFlagEquals(Long kinderNo, String classDeleteFlag);

}
