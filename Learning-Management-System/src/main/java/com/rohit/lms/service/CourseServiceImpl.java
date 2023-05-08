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
    public Integer createNewCourse(CoursesDto dto) {
        repository.save(mapper.toDomain(dto));
        return 1;
    }

    @Override
    public List<CoursesDto> all() {
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
    public Integer updateCourse(CoursesDto courses, Long courseId) {
        courses.setCourseId(courseId);
        repository.save(mapper.toDomain(courses));
        return 1;
    }

    @Override
    public CoursesDto fetchCourseDetails(Long courseID) throws CourseNotFoundException {
        Optional<Courses> op = repository.findById(courseID);
        return mapper.toDto(op.orElseThrow(() -> new CourseNotFoundException("Course " + courseID + " Not Found")));
    }

    @Override
    public List<CoursesDto> getCoursesByCourseName(String courseName) throws CourseNotFoundException {
        // TODO Auto-generated method stub
        //List<Course> courses = repository.findByCourseName(courseName);

        List<CoursesDto> collect = repository.findAllByCourseName(courseName).stream().map(mapper :: toDto).collect(Collectors.toList());

        if(collect.isEmpty()) throw new CourseNotFoundException("No courses found");
        return collect;

        //return repository.findByCourseName(courseName).stream().map(mapper :: toDto).collect(Collectors.toList());

    }
}