package com.example.RestAppChatGpt.dto;

import lombok.Data;

@Data
public class CompletionRequestDto {
    String model;
    String message;
}
