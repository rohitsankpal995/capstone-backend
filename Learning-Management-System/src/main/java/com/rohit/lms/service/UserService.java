package com.rohit.lms.service;

import com.rohit.lms.dto.*;
import com.rohit.lms.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    Integer signup(CreateUserDto dto);

    UserDto login(LoginDto dto) throws UserNotFoundException;

    LoginResponseDto loginUserForResponse(LoginDto dto);

    List<UserDto> getAllUser ();


    Integer enrollCourse(Long userId,Long bookingsId);

    List<UserCoursesDto> getAllEnrollments(Long userId);

    List<StudentEnrolledDto> getAllStudentEnrolled();

//    List<UserCoursesDto> getCurrentEnrollments(Long userId);
    Integer deleteUser(Long userId) throws UserNotFoundException;

    Integer updateUser(CreateUserDto dto);
    UserUpadteDto fetchUserDetails(Long id) throws UserNotFoundException;


}
