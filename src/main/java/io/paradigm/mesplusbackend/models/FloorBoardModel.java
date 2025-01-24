package io.paradigm.mesplusbackend.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "floorboard")
public class FloorBoardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobId;
    private String type;
    private String machineId;
    private LocalDateTime timeCreated;
    private String author;
    private Integer priorityLevel;
}

/*
 jobid: 'JOB-A1234',
    priority: 1,
    machineId: 'MACHINE003',
    timecreated: new Date(), // Just now
    desc: 'PANIC: Machine Error Occurred: Internal:, Lever4 is in Error state Affecting Unload, Product=PH6300048012[2024-07-14 11:48:30]',
    comments: [
      { user: "EscalanteJ", comment: 'Initial issue noted.', timecreated: new Date() },
      { user: "EscalanteJ", comment: 'Further investigation needed.', timecreated: new Date() }
    ],
    attachments: ['logfile1.txt', 'screenshot.png'],
    author: "EscalanteJ"
 */