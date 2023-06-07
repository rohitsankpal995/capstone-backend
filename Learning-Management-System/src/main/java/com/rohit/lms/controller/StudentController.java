package com.rohit.lms.controller;

import com.rohit.lms.domain.Student;
import com.rohit.lms.dto.AppResponse;
import com.rohit.lms.dto.MarkDto;
import com.rohit.lms.exception.StudentNotFoundException;
import com.rohit.lms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/student")
@RestController

public class StudentController {

        private StudentService studentService;


        @CrossOrigin
        @PostMapping(value="/marks", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<AppResponse<Integer>> createNewMark(@Valid @RequestBody Student student){
            final Integer sts = studentService.saveStudent(student);
            final AppResponse<Integer> response = AppResponse.<Integer>builder()
                    .sts("success")
                    .msg("Mark Added Successfully")
                    .bd(sts).build();
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        }

        @PostMapping("/calculate-result")
        public String calculateResult(@RequestBody Student student) {

            return studentService.calculateResult(student);
        }


        @GetMapping("/students/{id}")
        public ResponseEntity<Student> getStudent(@PathVariable Long id) {
                Student student = studentService.getStudentById(id);
                return ResponseEntity.ok(student);

        }

}
