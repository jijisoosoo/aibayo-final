package com.aico.aibayo.repository;

import com.querydsl.core.Tuple;

import java.util.List;

public interface NotepadRepositoryCustom {
    public List<Tuple> findAllByKinderNo(Long kinderNo);
}
