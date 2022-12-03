package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.StudentLessonRelationDTO;
import com.example.StudentPerformance.web.request.StudentLessonRelationRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class StudentLessonRelationMapperTest {

    private final StudentLessonRelationMapper mapper = Mappers.getMapper(StudentLessonRelationMapper.class);

    @Test
    void studentLessonRequestToStudentLessonDto() {
        StudentLessonRelationRequest studentLessonRelationRequest = new StudentLessonRelationRequest();
        studentLessonRelationRequest.setLessonId(1L);
        studentLessonRelationRequest.setLessonId(1L);
        studentLessonRelationRequest.setGrade(4.0);
        StudentLessonRelationDTO studentLessonRelationDTO = mapper.studentLessonRequestToStudentLessonDto(studentLessonRelationRequest);

        assertEquals(studentLessonRelationRequest.getStudentId(), studentLessonRelationDTO.getStudentId());
        assertEquals(studentLessonRelationRequest.getLessonId(), studentLessonRelationDTO.getLessonId());
        assertEquals(studentLessonRelationRequest.getGrade(), studentLessonRelationDTO.getGrade());
    }

    @Test
    void studentLessonDtoToStudentLessonRequest() {
        StudentLessonRelationDTO studentLessonRelationDTO = new StudentLessonRelationDTO();
        studentLessonRelationDTO.setStudentId(1L);
        studentLessonRelationDTO.setLessonId(1L);
        studentLessonRelationDTO.setGrade(4.0);
        StudentLessonRelationRequest studentLessonRelationRequest = mapper.studentLessonDtoToStudentLessonRequest(studentLessonRelationDTO);

        assertEquals(studentLessonRelationDTO.getStudentId(), studentLessonRelationRequest.getStudentId());
        assertEquals(studentLessonRelationDTO.getLessonId(), studentLessonRelationRequest.getLessonId());
        assertEquals(studentLessonRelationDTO.getGrade(), studentLessonRelationRequest.getGrade());
    }
}