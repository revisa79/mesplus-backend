package io.paradigm.mesplusbackend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Setter
@Getter
@Entity
@Table(name = "notification_queue")
public class NotificationQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message; //JSON String

    @Column(nullable = false)
    private String status = "PENDING"; // Example: PENDING, SENT, FAILED

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private int retryCount = 0; // Tracks the number of retries

    public NotificationQueue() {}

    public NotificationQueue(Map<String, Object> jsonMessage) {
        this.message = convertToJson(jsonMessage);
    }

    private String convertToJson(Map<String, Object> jsonMessage) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return objectMapper.writeValueAsString(jsonMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting message to JSON", e);
        }
    }
    /**
     *
     * mysql> DELIMITER $$
     * mysql> CREATE TRIGGER notify_changes
     *     -> AFTER INSERT ON loginlist
     *     -> FOR EACH ROW
     *     -> BEGIN
     *     ->     -- Insert a JSON message into notification_queue
     *     ->     INSERT INTO notification_queue (message, created_at)
     *     ->     VALUES (
     *     ->         JSON_OBJECT(
     *     ->             'id', NEW.id,
     *     ->             'action', 'insert',
     *     ->             'data', JSON_OBJECT('loginip', NEW.loginip, 'name', NEW.name)
     *     ->        ),
     *     ->         NOW()
     *     ->     );
     *     -> END;
     *     -> $$
     * Query OK, 0 rows affected (0.02 sec)
     *
     * mysql> DELIMITER ;
     *
     *
     */
}
