package com.rohit.lms.util;
import com.rohit.lms.domain.Courses;
import com.rohit.lms.dto.CoursesDto;
import org.springframework.stereotype.Component;




@Component
public class CourseMapper {

    public Courses toDomain(CoursesDto dto)
    {
        return new Courses(dto.getCourseID(), dto.getCourseName(), dto.getFacultyName(), dto.getMaterial(), dto.getRecordings(), dto.getStartDate(), dto.getEndDate());

    }

    public CoursesDto toDto(Courses domain)
    {
        return new CoursesDto(domain.getCourseId(),domain.getCourseName(),domain.getFacultyName(),domain.getStartDate(),domain.getEndDate(),domain.getMaterial(),domain.getRecording());
    }
}