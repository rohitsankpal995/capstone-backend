package com.rohit.lms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "enrollments")
public class Enrollments {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column( nullable = false)
    private Integer courseId;
    @Column(nullable = false)
    private Integer studentId;

    @ManyToOne
    @JoinColumn
    private Courses courses;
}
