package com.rohit.lms.util;

import org.springframework.stereotype.Component;

import com.rohit.lms.domain.User;
import com.rohit.lms.dto.UserDto;

@Component
public class UserMapper {
    
    public User toDomain(UserDto dto){
        
        return User.builder().id(dto.getId()).name(dto.getName()).email(dto.getEmail()).password(dto.getPassword()).role(dto.getRole()).build();
    }

    public UserDto toDto(User domain){
        return new UserDto(domain.getId(), domain.getName(), domain.getEmail(), domain.getPassword(), domain.getRole());
    }

}