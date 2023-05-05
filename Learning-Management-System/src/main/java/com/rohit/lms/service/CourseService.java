package com.rohit.lms.service;

import com.rohit.lms.dto.CoursesDto;
import com.rohit.lms.exception.UserNotFoundException;

import java.util.List;

public interface CourseService {

    Integer createNewBooking(CoursesDto dto);

    Integer createNewCourse(CoursesDto dto);

    List<CoursesDto> all();

    Integer deleteCourse(Long courseId) throws UserNotFoundException;

    Integer updateCourse(CoursesDto dto);

    CoursesDto fetchCourseDetails(Long id) throws UserNotFoundException;
}
