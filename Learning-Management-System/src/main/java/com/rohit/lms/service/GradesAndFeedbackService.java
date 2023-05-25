package com.rohit.lms.service;

import com.rohit.lms.dto.GardesAndFeedbackDto;

import java.util.List;

public interface GradesAndFeedbackService {

    Integer createGradedsAndFeedback(Long id, GardesAndFeedbackDto dto);

    List<GardesAndFeedbackDto> listAllGradesAndFeedbacks();
}
