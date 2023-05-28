package com.rohit.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.lms.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Long>{

}
