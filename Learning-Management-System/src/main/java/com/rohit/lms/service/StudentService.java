package com.rohit.lms.service;

import com.rohit.lms.domain.Student;
import com.rohit.lms.exception.InvalidMarksException;
import com.rohit.lms.exception.StudentNotFoundException;
import com.rohit.lms.repository.StudentRepository;
import com.rohit.lms.util.DynamicMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@AllArgsConstructor
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private final DynamicMapper dynamicMapper;

    public Integer saveStudent(Student student) {
        validateMarks(student.getMarks());
        studentRepository.save(student);
        return 1;
    }

    public String calculateResult(Student student) {
        int totalMarks = 0;
        for (int mark : student.getMarks()) {
            totalMarks += mark;
        }

        double percentage = (totalMarks / (student.getMarks().length * 100.0)) * 100;

        if (percentage >= 75) {
            return "Distinction";
        } else if (percentage >= 60) {
            return "First Class";
        } else if (percentage >= 50) {
            return "Second Class";
        } else {
            return "Fail";
        }
    }

    private void validateMarks(int[] marks) {
        if (marks.length != 4) {
            throw new InvalidMarksException("Exactly 4 subject marks are required.");
        }

        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarksException("Invalid mark: " + mark);
            }
        }
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }
}
