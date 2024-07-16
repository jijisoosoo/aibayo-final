package com.aico.aibayo.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class ChatMemberEntity {
    @Id
    @Field("user_id")
    private String userId;
    @Field("join_time")
    private String joinTime;
}
