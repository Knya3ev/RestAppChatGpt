package com.example.RestAppChatGpt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerationImagesBody {
    private String prompt;
    private Integer n;
    private String size;
}
