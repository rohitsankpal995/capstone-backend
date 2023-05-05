package com.rohit.lms.controller;

import com.rohit.lms.dto.AppResponse;
import com.rohit.lms.dto.CoursesDto;
import com.rohit.lms.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/courses")
@RestController
public class CoursesController {
    private final CourseService service;

    @CrossOrigin
    @PostMapping(value = "/createNewCourse", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewCourse(@RequestBody CoursesDto dto)
    {
        final Integer sts= service.createNewCourse(dto);

        final AppResponse<Integer> response= AppResponse.<Integer>builder()
                .sts("success")
                .msg("Course created Succesfully")
                .bd(sts)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @CrossOrigin
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<CoursesDto>>> allCourses() {
        List<CoursesDto> users = service.all();

        AppResponse<List<CoursesDto>> response = AppResponse.<List<CoursesDto>>builder()
                .sts("success")
                .msg("Courses")
                .bd(users)
                .build();

        return ResponseEntity.ok().body(response);
    }
    @PutMapping(value = "/updateCourse", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateCourse(@RequestBody CoursesDto dto) {

        final Integer sts = service.updateCourse(dto);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Course Updated Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/delete/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteCourse(@PathVariable Long courseId) {

        final Integer sts = service.deleteCourse(courseId);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Course Deleted Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.status(200).body(response);
    }
    @GetMapping(value = "/getCourseById/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AppResponse<CoursesDto>> getBookingById(@PathVariable Long courseId) {

        final CoursesDto dto = service.fetchCourseDetails(courseId);

        final AppResponse<CoursesDto> response = AppResponse.<CoursesDto>builder()
                .sts("success")
                .msg("Course Details")
                .bd(dto)
                .build();
        return ResponseEntity.ok().body(response);
    }
}
