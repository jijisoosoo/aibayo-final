package com.aico.aibayo.repository;

import com.aico.aibayo.dto.NotepadDto;
import com.querydsl.core.Tuple;

import java.util.List;

public interface NotepadRepositoryCustom {
    public List<NotepadDto> findAllByKinderNo(Long kinderNo);
}
