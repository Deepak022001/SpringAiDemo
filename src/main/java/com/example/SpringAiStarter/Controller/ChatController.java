package com.example.SpringAiStarter.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    public ChatController(ChatClient.Builder builder){
        this.chatClient=builder.build();
    }
    private final ChatClient chatClient;

    @GetMapping("/simple-chat")
    public String simpleChat(@RequestParam  String message){
        String respone=chatClient.prompt().user(message).call().content();
        return respone;
    }

}
