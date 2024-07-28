package io.paradigm.mesplusbackend.controller;

import io.paradigm.mesplusbackend.models.ChatMessage;
import io.paradigm.mesplusbackend.repo.ChatMessageRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ChatRestController {

    private final ChatMessageRepo chatMessageRepo;
    public ChatRestController(ChatMessageRepo chatMessageRepo){
        this.chatMessageRepo = chatMessageRepo;
    }


    @GetMapping("/messages")
    public ResponseEntity<List<ChatMessage>> getLast100Messages() {
        /// Fetch the top 100 messages ordered by id in descending order
        /// Pageable pageable = PageRequest.of(0, 100);   /// TODO: Use this by adding More button at the top of chatmenu
        List<ChatMessage> messages = chatMessageRepo.findTop100ByOrderByIdDesc();
        /// Reverse the order of the list
        Collections.reverse(messages);
        return ResponseEntity.ok(messages);
    }
}
