package com.spring.ollma.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AiController {


    private ChatClient client;

    public AiController(ChatClient.Builder client) {
        this.client = client.build();
    }

    @GetMapping("/chat")
    private List<Generation> chat(){
        PromptTemplate promptTemplate = new PromptTemplate("Hi, my name is Jerin. I'm currently processing, so please contact jerinjack111@gmail.com.");
        Prompt prompt = promptTemplate.create();
        ChatClient.ChatClientRequest.CallPromptResponseSpec responseSpec = client.prompt(prompt).call();
        return responseSpec.chatResponse().getResults();

    }

    @GetMapping("/chat-bot")
    private List<Generation> chatBot(@RequestParam String promptMessage){
        PromptTemplate promptTemplate = new PromptTemplate("your name JackMan chat bot your job is answer the question for whoever they ask to you "+promptMessage);
        Prompt prompt = promptTemplate.create();
        ChatClient.ChatClientRequest.CallPromptResponseSpec responseSpec = client.prompt(prompt).call();
        return responseSpec.chatResponse().getResults();

    }
}
