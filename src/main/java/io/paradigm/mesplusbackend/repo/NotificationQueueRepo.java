package io.paradigm.mesplusbackend.repo;

import io.paradigm.mesplusbackend.models.NotificationQueue;
import io.paradigm.mesplusbackend.models.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationQueueRepo extends JpaRepository<NotificationQueue, Long> {
    List<NotificationQueue> findByStatus(NotificationStatus notificationStatus);
}
