package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.CourseDto;
import com.example.StudentPerformance.entity.Course;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCourseFromDto(CourseDto courseDto, @MappingTarget Course course);

    CourseDto entityToDto(Course course);

    Course dtoToEntity(CourseDto courseDTO);
}
