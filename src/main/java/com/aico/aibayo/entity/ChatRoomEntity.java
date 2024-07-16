package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "chat_room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ChatRoomEntity {
    @Id
    @Field("chat_room_id")
    private String chatRoomId;
    @Field("chat_room_name")
    private String chatRoomName;
    @Field("chat_memebers")
    private List<ChatMemberEntity> chatMemberEntities;
    @Field("create_room_time")
    private LocalDateTime createRoomTime;
    @Field("update_room_time")
    private LocalDateTime updateRoomTime;
}
