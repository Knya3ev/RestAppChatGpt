package com.example.RestAppChatGpt.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerationImagesResponse {
    private Long created;
    private List<URLImages> data = new ArrayList<>();

    public List<String> getUrlImagesList(){
        List<String> resultList = new ArrayList<>();

        for(URLImages items : data) resultList.add(items.getUrl());

        return resultList;
    }

    public List<URLImages> getUrlImagesList(List<String> list){
        List<URLImages> resultList = new ArrayList<>();
        for (String item : list) {
            resultList.add(new URLImages(item));
        }
        return resultList;
    }
}

@JsonSubTypes.Type(value = URLImages.class, name = "data")
@Data
@AllArgsConstructor
@NoArgsConstructor
class URLImages{
    String url;
}
