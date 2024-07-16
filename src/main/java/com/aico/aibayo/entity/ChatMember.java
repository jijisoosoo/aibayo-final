package com.aico.aibayo.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class ChatMember {
    @Field("user_id")
    private String userId;
    @Field("join_time")
    private String joinTime;
}
