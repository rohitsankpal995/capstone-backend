package com.rohit.lms.repository;



import com.rohit.lms.domain.Courses;
import com.rohit.lms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses,Long> {
    List<Courses> findAllByCourseName(String courseName);



}
