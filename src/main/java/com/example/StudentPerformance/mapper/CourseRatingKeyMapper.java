package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.CourseRatingKeyDto;
import com.example.StudentPerformance.entity.CourseRatingKey;
import org.mapstruct.Mapper;

@Mapper
public interface CourseRatingKeyMapper {
    CourseRatingKey dtoToEntity(CourseRatingKeyDto courseRatingKeyDto);

    CourseRatingKeyDto entityToDto(CourseRatingKey courseRatingKey);
}
