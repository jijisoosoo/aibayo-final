package com.aico.aibayo.repository;

import com.aico.aibayo.entity.ChatMemberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMemberRepository extends MongoRepository<ChatMemberEntity, String> {
}
