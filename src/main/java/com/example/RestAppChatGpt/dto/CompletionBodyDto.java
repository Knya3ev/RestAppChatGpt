package com.example.RestAppChatGpt.dto;


import lombok.Data;

@Data
public class CompletionBodyDto {
    private String model;
    private String prompt;
    private Integer max_tokens = 7;
    private Integer top_p = 1;
    private Integer n = 1;
    private boolean stream = false;
    private Integer logprobs = null;
    private String stop = "\n";

}
