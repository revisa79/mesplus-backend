package io.paradigm.mesplusbackend.repo;

import io.paradigm.mesplusbackend.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatMessageRepo extends JpaRepository<ChatMessage, Long> {

    @Query("SELECT cm FROM ChatMessage cm ORDER BY cm.id DESC")
    List<ChatMessage> findTop100ByOrderByIdDesc();


}
