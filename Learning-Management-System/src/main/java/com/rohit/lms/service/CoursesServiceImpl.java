package com.rohit.lms.service;

import com.rohit.lms.domain.Courses;
import com.rohit.lms.domain.User;
import com.rohit.lms.dto.CoursesDto;
import com.rohit.lms.dto.CreateUserDto;
import com.rohit.lms.repository.CoursesRepository;
import com.rohit.lms.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Integer create(CoursesDto dto) {
        Courses courses = new Courses();
       Integer tearcherId = userRepository.findById(dto.getTeacherId()).get().getId();
       courses.setTeacherId(tearcherId);
       courses.setName(dto.getCourseName());
       courses.setStarDate(dto.getStartDate());
       courses.setEndDate(dto.getEndDate());
       coursesRepository.save(courses);
        return 1;
    }
}
