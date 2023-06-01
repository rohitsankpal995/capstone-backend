package com.rohit.lms.service;

import java.util.List;

import com.rohit.lms.dto.MarkDto;
import com.rohit.lms.exception.MarkNotFoundException;

public interface MarkService {

    Integer createNewMark(MarkDto mark);
    List<MarkDto> all();
    Integer deleteMark(Long id) throws MarkNotFoundException;
    MarkDto fetchMarkDetails(Long id) throws MarkNotFoundException;
    Integer updateMark(MarkDto mark);
}
