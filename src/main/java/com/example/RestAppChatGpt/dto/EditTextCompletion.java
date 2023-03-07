package com.example.RestAppChatGpt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditTextCompletion {
    private String model;
    private String input;
    private String instruction;
}
