package com.aico.aibayo.repository.classKid;

import com.aico.aibayo.dto.classKid.ClassKidDto;
import com.aico.aibayo.entity.QAcceptLogEntity;
import com.aico.aibayo.entity.QClassKidEntity;
import com.aico.aibayo.entity.QKidEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClassKidRepositoryCustomImpl implements ClassKidRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

//    private final QKidEntity kid = QKidEntity.kidEntity;
    private final QAcceptLogEntity acceptLog = QAcceptLogEntity.acceptLogEntity;
    private final QClassKidEntity classKid = QClassKidEntity.classKidEntity;


    @Override
    public List<ClassKidDto> findAllByClassNoAndKidNo(Long classNo, Long kidNo) {

        return jpaQueryFactory
                .select(Projections.constructor(ClassKidDto.class,
                        classKid.classNo,
                        classKid.kidNo,
                        classKid.acceptNo
                        ))
                .from(classKid)
                .join(acceptLog).on(acceptLog.acceptNo.eq(classKid.acceptNo)
                        .and(acceptLog.acceptStatus.eq(1)))
                .where(classKid.classNo.eq(classNo)
                        .and(classKid.kidNo.eq(kidNo)))
                .fetch();
    }
}
