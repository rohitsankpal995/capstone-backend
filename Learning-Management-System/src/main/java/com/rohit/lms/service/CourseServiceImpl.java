package com.rohit.lms.service;

import com.rohit.lms.domain.Courses;
import com.rohit.lms.exception.CourseNotFoundException;
import com.rohit.lms.exception.UserNotFoundException;
import com.rohit.lms.repository.CoursesRepository;
import com.rohit.lms.util.CourseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rohit.lms.dto.CoursesDto;


import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {


    private final CoursesRepository repository;
    private final CourseMapper mapper;


    @Override
    public Integer createNewBooking(CoursesDto dto) {
        repository.save(mapper.toDomain(dto));
        return 1;
    }

    @Override
    public Integer createNewCourse(CoursesDto dto) {
        return null;
    }

    @Override
    public List<CoursesDto> all() {
        repository.findAll().forEach(c->System.out.println(c.getCourseName()));
        return repository.findAll()
                .stream()
                // .map( invoice -> mapper.toDto(invoice) )
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer deleteCourse(Long courseId) throws UserNotFoundException {
        repository.deleteById(courseId);
        return 1;
    }

    @Override
    public Integer updateCourse(CoursesDto courses) {
        repository.save(mapper.toDomain(courses));
        return 1;
    }

    @Override
    public CoursesDto fetchCourseDetails(Long courseID) throws CourseNotFoundException {
        Optional<Courses> op = repository.findById(courseID);
        return mapper.toDto(op.orElseThrow(() -> new CourseNotFoundException("Booking " + courseID + " Not Found")));
    }
}