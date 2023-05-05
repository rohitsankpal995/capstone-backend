package com.rohit.lms.repository;



import com.rohit.lms.domain.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Long> {
}
