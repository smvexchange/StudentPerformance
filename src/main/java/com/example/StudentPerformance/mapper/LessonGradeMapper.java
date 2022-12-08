package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.LessonGradeDto;
import com.example.StudentPerformance.entity.LessonGrade;
import org.mapstruct.Mapper;

@Mapper
public interface LessonGradeMapper {

    LessonGradeDto entityToDto(LessonGrade lessonGrade);

    LessonGrade dtoToEntity(LessonGradeDto lessonGradeDto);
}
