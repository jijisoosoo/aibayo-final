package com.aico.aibayo.repository;

import com.aico.aibayo.entity.ChatUserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatUserRepository extends MongoRepository<ChatUserEntity, String> {
}
