package com.example.RestAppChatGpt.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatCompletionDto {
    private String model;
    private final List<MessageForChatDto> messages = new ArrayList<>();

    public void addMessage(String role, String content) {
        MessageForChatDto message = new MessageForChatDto(role, content);
        this.messages.add(message);
    }
}

@JsonSubTypes.Type(value = MessageForChatDto.class, name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
class MessageForChatDto {
    private String role;
    private String content;
}
