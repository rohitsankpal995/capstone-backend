package com.rohit.lms.service;

import com.rohit.lms.dto.CoursesDto;
import com.rohit.lms.exception.CourseNotFoundException;
import com.rohit.lms.exception.UserNotFoundException;

import java.util.List;

public interface CourseService {



    Integer createNewCourse(CoursesDto dto);

    List<CoursesDto> all();

    Integer deleteCourse(Long courseId) throws UserNotFoundException;

    Integer updateCourse(CoursesDto dto,Long courseId);

    CoursesDto fetchCourseDetails(Long id) throws UserNotFoundException;
    List<CoursesDto> getCoursesByCourseName(String courseName) throws CourseNotFoundException;
}
