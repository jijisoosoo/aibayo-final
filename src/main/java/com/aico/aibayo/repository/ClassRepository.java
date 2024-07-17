package com.aico.aibayo.repository;

import com.aico.aibayo.entity.ClassEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

public interface ClassRepository extends JpaAttributeConverter<ClassEntity, Integer> {
}
