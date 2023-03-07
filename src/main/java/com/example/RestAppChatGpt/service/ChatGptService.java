package com.example.RestAppChatGpt.service;

import com.example.RestAppChatGpt.client.ChatGptClient;
import com.example.RestAppChatGpt.dto.*;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ChatGptService {

    @Autowired
    private ChatGptClient client;

    @Value("${service.chat_gpt.api_key}")
    private String api_key;

    public String findAllModels() {
        return client.findAllModels(api_key);
    }

    public String findByNameModel(String model) {
        return client.findByNameModel(api_key, model);
    }

    public String createCompletion(String model, String message) {
        CompletionBodyDto completion = new CompletionBodyDto();
        completion.setModel(model);
        completion.setPrompt(message);

        String result = client.getCompletion(api_key, completion);
        return result;
    }

    public ChatCompletionDto sendMessageForChat(ChatCompletionDto chat) {
        String response = client.getChatCompletion(api_key, chat);

        JSONObject request = new JSONObject(response);
        request = request.getJSONArray("choices").getJSONObject(0).getJSONObject("message");

        chat.addMessage(request.getString("role"), request.getString("content"));

        return chat;
    }

    public String editTest(EditTextCompletion editTextCompletion) {
        return client.editTextCompletion(api_key, editTextCompletion);
    }

    public List<String> getImages(GenerationImagesBody images) {
        GenerationImagesResponse response = client.generationImages(api_key, images);
        return response.getUrlImagesList();
    }

    public String editImage(MultipartFile image, MultipartFile mask, String prompt, Integer n, String size) throws IOException {
        String json = client.editImages(api_key, image, mask, prompt, n, size);

        return json;
    }


}
