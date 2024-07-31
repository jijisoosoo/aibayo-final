package com.aico.aibayo.repository.teacherManage;

import com.aico.aibayo.entity.ClassTeacherEntity;
import com.aico.aibayo.entity.ClassTeacherId;
import com.aico.aibayo.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<MemberEntity, Long> {
}
