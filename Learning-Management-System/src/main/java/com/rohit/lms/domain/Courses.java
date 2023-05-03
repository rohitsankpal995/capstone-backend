package com.rohit.lms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "courses")
public class Courses {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer teacherId;
    @Column(nullable = false)
    private LocalDate starDate;
    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Enrollments> enrollmentsList=new ArrayList<>();

    @OneToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Classes>classesList =new ArrayList<>();
}
