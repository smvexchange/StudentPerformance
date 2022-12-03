package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.StudentCourseRelationDTO;
import com.example.StudentPerformance.web.request.StudentCourseRelationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentCourseRelationMapper {

    StudentCourseRelationDTO studentCourseRequestToStudentCourseDto(StudentCourseRelationRequest studentCourseRelationRequest);

    StudentCourseRelationRequest studentCourseDtoToStudentCourseRequest(StudentCourseRelationDTO studentCourseRelationDTO);
}
