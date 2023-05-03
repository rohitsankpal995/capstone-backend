package com.rohit.lms.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "notifications")
public class Notifications {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(nullable = false)
    private String content;
    private LocalTime created;

    @ManyToOne
    @JoinColumn
    private User sender ;
    @ManyToOne
    @JoinColumn
    private User receiver;

}
