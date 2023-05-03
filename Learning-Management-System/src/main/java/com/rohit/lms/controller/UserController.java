package com.rohit.lms.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.lms.Service.UserService;
import com.rohit.lms.dto.AppResponse;
import com.rohit.lms.dto.UserDto;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;


    @PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> create(@Valid @RequestBody UserDto dto) {
        final Integer sts= service.createUser(dto);
        AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("Success")
                .msg("User created successfully")
                .bd(sts)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<UserDto>> login(@RequestParam String email, @RequestParam String password) {
        UserDto user = service.loginUser(email, password);
        AppResponse<UserDto> response = AppResponse.<UserDto>builder()
                .sts("Success")
                .msg("User logged in successfully")
                .bd(user)
                .build();
        return ResponseEntity.ok().body(response);
    }
}
