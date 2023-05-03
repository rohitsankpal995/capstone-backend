package com.rohit.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.lms.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByUserNameAndPassword(String userName, String password);
}
