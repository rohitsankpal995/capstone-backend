package com.rohit.lms.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(unique = true, nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
    private LocalDate created;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Courses> coursesList = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private  List<Classes> userClassesList =new ArrayList<>();

    @OneToMany(mappedBy = "sender",cascade = CascadeType.ALL)
    private List<Notifications> senderNotificationsList =new ArrayList<>();

    @OneToMany(mappedBy = "receiver",cascade = CascadeType.ALL)
    private List<Notifications> recieverNotificationsList =new ArrayList<>();


}