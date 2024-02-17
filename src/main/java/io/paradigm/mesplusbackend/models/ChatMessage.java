package io.paradigm.mesplusbackend.models;


import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chatmessage")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private MessageType type;
    private String content;
    private String sender;


}