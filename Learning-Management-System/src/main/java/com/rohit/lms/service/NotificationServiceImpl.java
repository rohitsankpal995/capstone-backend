package com.rohit.lms.service;

import com.rohit.lms.domain.Notification;
import com.rohit.lms.dto.NotificationDto;
import com.rohit.lms.exception.NotificationNotFoundException;
import com.rohit.lms.repository.NotificationRepository;
import com.rohit.lms.util.NotificationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService{

    public final NotificationRepository repository;
    public final NotificationMapper mapper;


    @Override
    public Integer createNewNotification(NotificationDto dto) {
        // TODO Auto-generated method stub
        repository.save(mapper.toDomain(dto));
        return 1;
    }


    @Override
    public List<NotificationDto> all() {
        // TODO Auto-generated method stub
        return repository.findAll().stream().map(mapper :: toDto).collect(Collectors.toList());
    }


    @Override
    public Integer deleteNotification(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
        return 1;
    }


    @Override
    public NotificationDto fetchNotificationDetails(Long id) {
        // TODO Auto-generated method stub
        Optional<Notification> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new NotificationNotFoundException("Notification" + id + "Not Found")));
    }


    @Override
    public Integer updateNotification(NotificationDto dto) {
        // TODO Auto-generated method stub
        Long id= dto.getId();
        Notification notification= repository.findById(id).orElseThrow(() -> new NotificationNotFoundException("Notification not found"));
        notification.setDate(dto.getDate());
        notification.setNotification(dto.getNotification());
        repository.save(notification);


        return 1;
    }

}
