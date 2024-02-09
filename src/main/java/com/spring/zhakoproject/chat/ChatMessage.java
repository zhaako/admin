package com.spring.zhakoproject.chat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Chatting")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "content")
    private String content;
    @Column(name = "sender")
    private String sender;
    @Column(name="type")
    private MessageType type;
}

