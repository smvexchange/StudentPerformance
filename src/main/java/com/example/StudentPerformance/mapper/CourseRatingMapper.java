package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.CourseRatingDto;
import com.example.StudentPerformance.entity.CourseRating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseRatingMapper {

    CourseRatingDto entityToDto(CourseRating courseRating);

    CourseRating dtoToEntity(CourseRatingDto courseRatingDto);
}
