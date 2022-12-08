package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.LessonDto;
import com.example.StudentPerformance.entity.Lesson;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface LessonMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLessonFromDto(LessonDto lessonDto, @MappingTarget Lesson lesson);

    LessonDto entityToDto(Lesson lesson);

    Lesson dtoToEntity(LessonDto lessonDTO);
}
