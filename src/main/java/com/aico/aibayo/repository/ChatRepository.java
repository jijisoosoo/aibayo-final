package com.aico.aibayo.repository;

import com.aico.aibayo.entity.ChatEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<ChatEntity, String> {
}
