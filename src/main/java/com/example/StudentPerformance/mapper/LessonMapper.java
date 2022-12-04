package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.LessonDto;
import com.example.StudentPerformance.entity.Lesson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    LessonDto entityToDto(Lesson lesson);

    Lesson dtoToEntity(LessonDto lessonDTO);
}
