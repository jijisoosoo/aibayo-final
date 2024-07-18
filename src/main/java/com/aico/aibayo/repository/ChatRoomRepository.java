package com.aico.aibayo.repository;

import com.aico.aibayo.entity.ChatRoomEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<ChatRoomEntity, String> {
}
