package com.rohit.lms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class StudentDto {
    private String name;
    private int[] marks;
}
