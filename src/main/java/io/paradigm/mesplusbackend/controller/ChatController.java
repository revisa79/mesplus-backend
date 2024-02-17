package io.paradigm.mesplusbackend.controller;
import io.paradigm.mesplusbackend.WebSocketEventListener;
import io.paradigm.mesplusbackend.repo.ChatMessageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import io.paradigm.mesplusbackend.models.ChatMessage;
@Controller
public class ChatController {
    @Autowired
    private ChatMessageRepo chatMessageRepo;
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ) {
        logger.info("Debugging ChatMessage : " + chatMessage);
        chatMessageRepo.save(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
