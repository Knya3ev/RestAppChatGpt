package com.example.RestAppChatGpt.controller;

import com.example.RestAppChatGpt.service.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ChatGptService service;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        String json = service.findAllModels();
        return new ResponseEntity<>(json,HttpStatus.OK);
    }
    @GetMapping("/get/{model}")
    public ResponseEntity<?> getModel(@PathVariable("model") String model){
        String response = service.findByNameModel(model);
        return response != null
                ? new ResponseEntity<>(response,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
