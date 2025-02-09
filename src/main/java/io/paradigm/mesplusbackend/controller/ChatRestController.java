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
        /// Pageable pageable = PageRequest.of(0, 100);
        /// TODO: Use this by adding More button at the top of chatmenu
        /// TODO: Do NOT use pageable in webchat. See footnotes below.
        List<ChatMessage> messages = chatMessageRepo.findTop100ByOrderByIdDesc();
        /// Reverse the order of the list
        Collections.reverse(messages);
        return ResponseEntity.ok(messages);
    }
}

/** Why NOT use Pageable for Web Chat?
 * 1. Pageable Uses OFFSET-Based Pagination (Bad for Chat)
 *     If you have millions of messages, LIMIT 100 OFFSET 100000 will scan 100,100 rows, slowing down performance.
 *     This is fine for reports but not great for chat history.
 * 2.You Need Reverse Chronological Order
 *     Pageable usually returns results in ascending order (id ASC), but in chat, you need latest first (timestamp DESC).
 *     Pageable doesn’t efficiently support this when fetching next pages.
 * 3. You Need to Keep Previously Loaded Messages
 *     Pageable replaces old messages when changing pages, but chat should keep older messages visible while loading new ones.
 *
 *
 *  public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
 *     @Query("SELECT m FROM ChatMessage m WHERE m.chatRoom.id = :chatRoomId AND m.timestamp < :lastLoadedTimestamp ORDER BY m.timestamp DESC")
 *     List<ChatMessage> findOlderMessages(@Param("chatRoomId") Long chatRoomId, @Param("lastLoadedTimestamp") Instant lastLoadedTimestamp, Pageable pageable);
 * }*/