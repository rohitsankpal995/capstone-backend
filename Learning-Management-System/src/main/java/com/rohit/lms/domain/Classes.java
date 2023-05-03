package com.rohit.lms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "classes")
public class Classes {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(nullable = false)
    private Integer courseId;
    @Column(nullable = false)
    private Integer teacherId;
    private LocalTime startTime;

    private LocalTime endTime;


    @ManyToOne
    @JoinColumn
    private Courses courses;

    @ManyToOne
    @JoinColumn
    private User user;

}
