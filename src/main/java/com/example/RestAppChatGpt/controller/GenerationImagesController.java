package com.example.RestAppChatGpt.controller;


import com.example.RestAppChatGpt.dto.GenerationImagesBody;
import com.example.RestAppChatGpt.dto.GenerationImagesResponse;
import com.example.RestAppChatGpt.service.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/images")
public class GenerationImagesController {

    @Value("${service.chat_gpt.api_key}")
    private String api_key;

    @Autowired
    private ChatGptService service;


    @PostMapping("/generation")
    public ResponseEntity<?> getGenerationImages(@RequestBody() GenerationImagesBody body) {
        List<String> response = service.getImages(body);
        HttpHeaders headers = new HttpHeaders();

        if (response.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (response.size() == 1) {
            headers.setLocation(URI.create(response.get(0)));
            return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
        }
        GenerationImagesResponse result = new GenerationImagesResponse();
        headers.setAccept(new ArrayList<>(Arrays.asList(new MediaType("application.json"))));

        return new ResponseEntity<>(result.getUrlImagesList(response), headers, HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editImage(@RequestParam("image") MultipartFile image,
                                       @RequestParam("mask") MultipartFile mask,
                                       @RequestParam("prompt") String prompt,
                                       @RequestParam("n") Integer n,
                                       @RequestParam("size") String size) throws IOException {

        String response = service.editImage(image,mask,prompt,n,size);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
