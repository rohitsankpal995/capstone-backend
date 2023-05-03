package com.rohit.lms.Service;

import com.rohit.lms.domain.User;
import com.rohit.lms.exception.UserNotFoundException;


public interface UserDetailsService {
    User loadUserByUsername(String username) throws UserNotFoundException;
}
