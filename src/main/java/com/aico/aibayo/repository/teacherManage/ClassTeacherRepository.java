package com.aico.aibayo.repository.teacherManage;

import com.aico.aibayo.entity.ClassTeacherEntity;
import com.aico.aibayo.entity.ClassTeacherId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassTeacherRepository extends JpaRepository<ClassTeacherEntity, ClassTeacherId> {
}
