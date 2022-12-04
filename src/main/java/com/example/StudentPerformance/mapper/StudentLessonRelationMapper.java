package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.StudentLessonRelationDto;
import com.example.StudentPerformance.entity.LessonGrade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentLessonRelationMapper {

    StudentLessonRelationDto entityToDto(LessonGrade lessonGrade);

    LessonGrade dtoToEntity(StudentLessonRelationDto studentLessonRelationDto);
}
