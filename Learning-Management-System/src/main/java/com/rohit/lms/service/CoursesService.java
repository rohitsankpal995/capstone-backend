package com.rohit.lms.service;

import com.rohit.lms.dto.CoursesDto;
import com.rohit.lms.dto.CreateUserDto;

public interface CoursesService {
    Integer create(CoursesDto dto);
}
