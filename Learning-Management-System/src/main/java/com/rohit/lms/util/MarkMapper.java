package com.rohit.lms.util;

import org.springframework.stereotype.Component;

import com.rohit.lms.domain.Mark;
import com.rohit.lms.dto.MarkDto;

@Component
public class MarkMapper {

    public Mark toDomain(MarkDto dto){
        return Mark.builder().name(dto.getName()).marks(dto.getMarks()).grade(dto.getGrade()).feedback(dto.getFeedback()).build();

    }

    public MarkDto toDto(Mark domain){
        return new MarkDto(domain.getId(), domain.getName(), domain.getMarks(), domain.getGrade(), domain.getFeedback() );
    }
}
