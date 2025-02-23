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
@Table(name = "loginlist")
public class LoginParamType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDateTime logintime;
    private String loginip;
}
