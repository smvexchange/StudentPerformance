package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.CourseDTO;
import com.example.StudentPerformance.web.request.CourseRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO courseRequestToCourseDto(CourseRequest courseRequest);

    CourseRequest courseDtoToCourseRequest(CourseDTO courseDTO);
}
