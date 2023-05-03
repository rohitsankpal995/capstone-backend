package com.rohit.lms.service;

import com.rohit.lms.dto.CreateUserDto;
import com.rohit.lms.dto.LoginDto;
import com.rohit.lms.dto.UserDto;
import com.rohit.lms.exception.UserNotFoundException;

public interface UserService {
    Integer signup(CreateUserDto dto);

    UserDto login(LoginDto dto) throws UserNotFoundException;
}
