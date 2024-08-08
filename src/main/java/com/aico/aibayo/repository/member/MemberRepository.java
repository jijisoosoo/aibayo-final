package com.aico.aibayo.repository.member;

import com.aico.aibayo.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>, MemberRepositoryCustom {
    Boolean existsByUsername(String username);
    MemberEntity findByUsername(String username);
}
