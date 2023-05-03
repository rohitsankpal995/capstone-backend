package com.rohit.lms.Service;

import com.rohit.lms.domain.User;
import com.rohit.lms.dto.UserDto;
import com.rohit.lms.exception.UserNotFoundException;


public interface UserService {
    Integer createUser(UserDto dto);
    UserDto loginUser(String email, String password);
}
