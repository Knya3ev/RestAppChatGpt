package com.example.RestAppChatGpt.controller;


import com.example.RestAppChatGpt.dto.ChatCompletionDto;
import com.example.RestAppChatGpt.dto.CompletionRequestDto;
import com.example.RestAppChatGpt.dto.EditTextCompletion;
import com.example.RestAppChatGpt.service.ChatGptService;
import com.example.RestAppChatGpt.util.RequestHandler;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/completion")
public class CompletionController {

    @Autowired
    private ChatGptService service;

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity handleException(Exception e){
//        return RequestHandler.getBadRequest(e);
//    }

    @PostMapping("/send_message")
    public ResponseEntity<?> sendCompletion(@RequestBody CompletionRequestDto body) {
        String response = service.createCompletion(body.getModel(), body.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(new ArrayList<>(Arrays.asList(new MediaType("application.json"))));

        return response != null
                ? new ResponseEntity<>(response, headers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/chat/send_message")
    public ResponseEntity<?> sendChatCompletion(@RequestBody ChatCompletionDto body) {
        ChatCompletionDto response = service.sendMessageForChat(body);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(new ArrayList<>(Arrays.asList(new MediaType("application.json"))));

        return response != null
                ? new ResponseEntity<>(response, headers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/edit_text")
    public ResponseEntity<?> editTest(@RequestBody EditTextCompletion body){
        String response = service.editTest(body);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(new ArrayList<>(Arrays.asList(new MediaType("application.json"))));

        return response != null
                ? new ResponseEntity<>(response,headers,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
