package com.rohit.lms.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.rohit.lms.domain.User;
import com.rohit.lms.dto.CreateUserDto;
import com.rohit.lms.dto.LoginDto;
import com.rohit.lms.dto.UserDto;
import com.rohit.lms.exception.UserNotFoundException;
import com.rohit.lms.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Integer signup(CreateUserDto dto) {
        User user = new User();
        user.setCreated(LocalDate.now());
        BeanUtils.copyProperties(dto, user);
        repository.save(user);
        return 1;
    }

    @Override
    public UserDto login(LoginDto dto) throws UserNotFoundException {
        Optional<User> op = repository.findByUserNameAndPassword(dto.getUserName(), dto.getPassword());
        User user = op.orElseThrow(() -> new UserNotFoundException("User Not Found"));

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }
}
