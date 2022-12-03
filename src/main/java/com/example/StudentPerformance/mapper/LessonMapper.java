package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.LessonDTO;
import com.example.StudentPerformance.web.request.LessonRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    LessonDTO lessonRequestToLessonDTO(LessonRequest lessonRequest);

    LessonRequest lessonDtoToLessonRequest(LessonDTO lessonDTO);
}
