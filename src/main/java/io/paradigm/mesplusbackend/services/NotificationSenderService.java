package io.paradigm.mesplusbackend.services;

import io.paradigm.mesplusbackend.models.NotificationQueue;
import io.paradigm.mesplusbackend.repo.NotificationQueueRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import io.paradigm.mesplusbackend.models.NotificationStatus;


@Service
@Slf4j
public class NotificationSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final NotificationQueueRepo notificationQueueRepo;

    public NotificationSenderService(RabbitTemplate rabbitTemplate, NotificationQueueRepo repository) {
        this.rabbitTemplate = rabbitTemplate;
        this.notificationQueueRepo = repository;
    }

    @Scheduled(fixedDelay = 10000) // Runs every 10 seconds
    public void sendPendingNotifications() {
        log.info("Scheduled notification process...");
        if (!isRabbitMQAvailable()) {
            log.info("RabbitMQ is down. Skipping processing notification...");
            return; // Skip retrying if RabbitMQ is down
        }

        List<NotificationQueue> pendingNotifications = notificationQueueRepo.findByStatus(NotificationStatus.PENDING);
        log.info("Notification Queue : Total of "+ pendingNotifications.size());
        /// Sending each PENDING notification_queue to RabbitMQ
        for (NotificationQueue notification : pendingNotifications) {
            log.info("Notification Queue : Trying to send message - " + notification.getMessage());

            NotificationStatus originalStatus = notification.getStatus();
            int originalRetryCount = notification.getRetryCount();

            try {
                rabbitTemplate.convertAndSend("db_changes_exchange", "routing-key", notification.getMessage());
                notification.setStatus(NotificationStatus.SENT);  // Update status
            } catch (Exception e) {
                notification.setRetryCount(notification.getRetryCount() + 1);
                log.error("Notification Queue : Failed to send message - {}, retry count: {}", e.getMessage(), notification.getRetryCount());

                if (notification.getRetryCount() >= 5) {
                    notification.setStatus(NotificationStatus.FAILED);
                }
            }

            /// Save only if there are actual changes
            if (notification.getStatus() != originalStatus || notification.getRetryCount() != originalRetryCount) {
                notificationQueueRepo.save(notification);
            }
        }

    }

    private boolean isRabbitMQAvailable() {
        try {
            rabbitTemplate.execute(channel -> true); // Test if RabbitMQ connection works
            return true;
        } catch (Exception e) {
            return false; // RabbitMQ is completely down
        }
    }
}
