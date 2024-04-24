package com.springai.springai.controllers;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class AiController {

    private final OllamaChatClient chatClient;

    @Autowired
    public AiController(OllamaChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ollama")
    public Flux<String> getChatResponse(@RequestParam(value = "message", defaultValue = "resuma o spring cloud open feign") String message) {
            return chatClient.stream(message);
    }
}
