package io.paradigm.mesplusbackend.repo;

import io.paradigm.mesplusbackend.models.ChatMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

/// TODO: Set the limit to the last message seen by the user not just 100 last message.
public interface ChatMessageRepo extends JpaRepository<ChatMessage, Long> {

    @Query("SELECT cm FROM ChatMessage cm ORDER BY cm.id DESC")
    List<ChatMessage> findTop100ByOrderByIdDesc(Pageable pageable);
}
