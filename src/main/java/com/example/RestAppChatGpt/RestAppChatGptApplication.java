package com.example.RestAppChatGpt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestAppChatGptApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAppChatGptApplication.class, args);
	}

}
