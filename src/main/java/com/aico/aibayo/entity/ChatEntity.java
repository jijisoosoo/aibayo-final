package com.aico.aibayo.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "chat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ChatEntity {
    @Id
    @Field("chat_id")
    private String chatId;
    @Field("chat_room_id")
    private String chatRoomId;
    @Field("sender_id")
    private String senderId;
    @Field("chat_type")
    private ChatType chatType;
    @Field("chat_content")
    private String chatContent;
    @Field("create_chat_time")
    private LocalDateTime createChatTime;
}
