package com.example.RestAppChatGpt.client;


import com.example.RestAppChatGpt.config.FeignSupportConfig;
import com.example.RestAppChatGpt.dto.*;
import feign.Headers;
import feign.Param;
import feign.form.FormProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(name = "client-chat-gpt", url = "${service.chat_gpt.url}",configuration = FeignSupportConfig.class)
public interface ChatGptClient {

    @GetMapping("/v1/models")
    String findAllModels(@RequestHeader("Authorization") String api_key);

    @GetMapping("/v1/models/{model}")
    String findByNameModel(@RequestHeader("Authorization") String apy_key,
                           @RequestParam("model") String model);

    @Headers("Content-Type: application.json")
    @PostMapping("/v1/completions")
    String getCompletion(@RequestHeader("Authorization") String apy_key,
                         @RequestBody() CompletionBodyDto body);


    @Headers("Content-Type: application.json")
    @PostMapping("/v1/chat/completions")
    String getChatCompletion(@RequestHeader("Authorization") String apy_key,
                             @RequestBody() ChatCompletionDto body);

    @Headers("Content-Type: application.json")
    @PostMapping("/v1/edits")
    String editTextCompletion(@RequestHeader("Authorization") String apy_key,
                              @RequestBody() EditTextCompletion textEdit);


    @Headers("Content-Type: application.json")
    @PostMapping("/v1/images/generations")
    GenerationImagesResponse generationImages(@RequestHeader("Authorization") String apy_key,
                                              @RequestBody() GenerationImagesBody generationImagesBody);

    @Headers("Content-Type: multipart/form-data")
    @PostMapping(value = "/v1/images/edits", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String editImages(@RequestHeader("Authorization") String apy_key,
                      @RequestPart("image") MultipartFile image,
                      @RequestPart("mask") MultipartFile mask,
                      @RequestPart("prompt") String prompt,
                      @RequestPart("n") Integer n,
                      @RequestPart("size") String size);


}



