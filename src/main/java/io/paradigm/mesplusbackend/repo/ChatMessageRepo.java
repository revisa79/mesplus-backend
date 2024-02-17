package io.paradigm.mesplusbackend.repo;

import io.paradigm.mesplusbackend.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepo extends JpaRepository<ChatMessage, Long> {


}
