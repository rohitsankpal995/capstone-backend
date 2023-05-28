package com.rohit.lms.service;

import com.rohit.lms.dto.NotificationDto;
import com.rohit.lms.exception.NotificationNotFoundException;

import java.util.List;

public interface NotificationService {

    Integer createNewNotification(NotificationDto notification);
    List<NotificationDto> all();
    Integer deleteNotification(Long id) throws NotificationNotFoundException;
    NotificationDto fetchNotificationDetails(Long id) throws NotificationNotFoundException;
    Integer updateNotification(NotificationDto notification);

}
