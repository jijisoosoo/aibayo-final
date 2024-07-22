package com.aico.aibayo.repository.classManage;

import com.aico.aibayo.entity.ClassEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Integer>, ClassRepositoryCustom {
}
