package com.rohit.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CoursesDto {
    private String courseName;
    private Integer teacherId;
    private LocalDate startDate;
    private LocalDate endDate;
}
