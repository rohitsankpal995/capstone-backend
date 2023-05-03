package com.rohit.lms.controller;


import com.rohit.lms.dto.AppResponse;
import com.rohit.lms.dto.CoursesDto;
import com.rohit.lms.dto.CreateUserDto;
import com.rohit.lms.service.CoursesService;
import com.rohit.lms.service.CoursesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequestMapping(value = "/courses")
@RestController
public class CourseController {
    @Autowired
    private CoursesServiceImpl service;
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE )
    public String addCourse( @RequestBody CoursesDto dto) {
        final Integer sts = service.create(dto);
//
//        AppResponse<Integer> res = AppResponse.<Integer>builder()
//                .sts("success")
//                .msg("Course Created")
//                .bd(sts)
//                .build();
//
//        return ResponseEntity.ok().body(res);
        return "successfully corse created";
    }
}
