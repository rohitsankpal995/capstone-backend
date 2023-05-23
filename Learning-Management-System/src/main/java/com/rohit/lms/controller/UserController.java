package com.rohit.lms.controller;



import javax.validation.Valid;

import com.rohit.lms.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rohit.lms.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/user")
@RestController
public class UserController {
    
    private final UserService service;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AppResponse<Integer>> signup(@Valid @RequestBody CreateUserDto dto) {
        final Integer sts = service.signup(dto);

        AppResponse<Integer> res = AppResponse.<Integer>builder()
                                                .sts("success")
                                                .msg("User Created")
                                                .bd(sts)
                                                .build();

        return ResponseEntity.ok().body(res);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AppResponse<UserDto>> login(@Valid @RequestBody LoginDto dto) {
        final UserDto resDto = service.login(dto);

        AppResponse<UserDto> res = AppResponse.<UserDto>builder()
                                                .sts("success")
                                                .msg("Login Success")
                                                .bd(resDto)
                                                .build();

        return ResponseEntity.ok().body(res);
    }
    @PostMapping(value = "/loginv2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<LoginResponseDto>> loginResponseDetails(@Valid @RequestBody LoginDto dto) {
        LoginResponseDto loginUser = service.loginUserForResponse(dto);
        AppResponse<LoginResponseDto> response = AppResponse.<LoginResponseDto>builder()
                .sts("success")
                .msg("user login as...")
                .bd(loginUser)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping(value = "/{userId}/userEnrollments/{courseId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> enrollCourse(@Valid @PathVariable Long userId, @PathVariable Long courseId) {
        Integer enrollCourse = service.enrollCourse(userId, courseId);
        AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("new course enrolled successfully.")
                .bd(enrollCourse)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping(value = "/getuserEnrollments/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<AppResponse<List<UserCoursesDto>>> findAll(@PathVariable Long userId) {
       List<UserCoursesDto> sts=  service.getAllEnrollments(userId);
        AppResponse<List<UserCoursesDto>> response=AppResponse.<List<UserCoursesDto>>builder()
                .sts("success")
                .msg("All current enrollments")
                .bd(sts)
                .build();
        return ResponseEntity.ok().body(response);
    }


//    @GetMapping(value = "/getcurrentEnrollments/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<AppResponse<List<UserCoursesDto>>> getCurrentBookings(@PathVariable Long userId) {
//        List<UserCoursesDto> sts=service.getCurrentEnrollments(userId);
//        AppResponse<List<UserCoursesDto>> response=AppResponse.<List<UserCoursesDto>>builder()
//                .sts("success")
//                .msg("All current enrollments")
//                .bd(sts)
//                .build();
//        return ResponseEntity.ok().body(response);
//    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<UserDto>>> findAllUsers() {
        List<UserDto> users = service.getAllUser();
        AppResponse<List<UserDto>> response = AppResponse.<List<UserDto>>builder()
                .sts("success")
                .msg("All users")
                .bd(users)
                .build();
        return ResponseEntity.ok().body(response);
    }
    @GetMapping(value = "/allStudentEnrolled", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<StudentEnrolledDto>>> getAllUserBookings() {
        List<StudentEnrolledDto> sts = service.getAllStudentEnrolled();
        AppResponse<List<StudentEnrolledDto>> response = AppResponse.<List<StudentEnrolledDto>>builder()
                .sts("success")
                .msg("All User Bookings")
                .bd(sts)
                .build();
        return ResponseEntity.ok().body(response);
    }

}