package com.example.RestAppChatGpt.service;

import com.example.RestAppChatGpt.client.ChatGptClient;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatGptServiceTest {

    @MockBean
    private ChatGptClient client;

    @Value("service.chat_gpt.api_key")
    private String api_key;

    @Test
    void findAllModels() {
        given(client.findAllModels(api_key)).willReturn("{\"data\":{\"model\":\"ff\"}}");

        String json = client.findAllModels(api_key);
        JSONObject request = new JSONObject(json);
        String result = request.getJSONObject("data").getString("model");

        Assertions.assertNotNull(result);
    }
    @Test
    void findByNameModel() {
        given(client.findAllModels(api_key)).willReturn("{\"data\":{\"model\":\"ff\"}}");

        String json = client.findByNameModel(api_key,"name_model");
        JSONObject request = new JSONObject(json);
        String result =request.getJSONObject("data").getString("model");

        Assertions.assertNotNull(result);
    }
}