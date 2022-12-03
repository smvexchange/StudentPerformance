package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.StudentLessonRelationDTO;
import com.example.StudentPerformance.web.request.StudentLessonRelationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentLessonRelationMapper {

    StudentLessonRelationDTO studentLessonRequestToStudentLessonDto(StudentLessonRelationRequest studentLessonRelationRequest);

    StudentLessonRelationRequest studentLessonDtoToStudentLessonRequest(StudentLessonRelationDTO studentLessonRelationDTO);
}
