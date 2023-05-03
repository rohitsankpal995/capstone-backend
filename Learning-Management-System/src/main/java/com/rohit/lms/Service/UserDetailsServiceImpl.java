package com.rohit.lms.Service;

import com.rohit.lms.domain.User;
import com.rohit.lms.exception.UserNotFoundException;
import com.rohit.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UserNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }

   
}
