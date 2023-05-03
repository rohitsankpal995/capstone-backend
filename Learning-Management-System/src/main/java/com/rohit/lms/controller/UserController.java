package com.rohit.lms.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.lms.dto.AppResponse;
import com.rohit.lms.dto.CreateUserDto;
import com.rohit.lms.dto.LoginDto;
import com.rohit.lms.dto.UserDto;
import com.rohit.lms.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(value = "/user")
@RestController
public class UserController {
    @Autowired
    private  UserService service;

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
}