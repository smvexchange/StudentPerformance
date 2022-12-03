package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.StudentCourseRelationDTO;
import com.example.StudentPerformance.web.request.StudentCourseRelationRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class StudentCourseRelationMapperTest {

    private final StudentCourseRelationMapper mapper = Mappers.getMapper(StudentCourseRelationMapper .class);

    @Test
    void studentCourseRequestToStudentCourseDto() {
        StudentCourseRelationRequest studentCourseRelationRequest = new StudentCourseRelationRequest();
        studentCourseRelationRequest.setStudentId(1L);
        studentCourseRelationRequest.setCourseName("JAVA");
        studentCourseRelationRequest.setRating(0.66);
        StudentCourseRelationDTO studentCourseRelationDTO = mapper.studentCourseRequestToStudentCourseDto(studentCourseRelationRequest);

        assertEquals(studentCourseRelationRequest.getStudentId(),studentCourseRelationDTO.getStudentId());
        assertEquals(studentCourseRelationRequest.getCourseName(),studentCourseRelationDTO.getCourseName());
        assertEquals(studentCourseRelationRequest.getRating(),studentCourseRelationDTO.getRating());
    }

    @Test
    void studentCourseDtoToStudentCourseRequest() {
        StudentCourseRelationDTO studentCourseRelationDTO = new StudentCourseRelationDTO();
        studentCourseRelationDTO.setStudentId(1L);
        studentCourseRelationDTO.setCourseName("JAVA");
        studentCourseRelationDTO.setRating(0.66);
        StudentCourseRelationRequest studentCourseRelationRequest = mapper.studentCourseDtoToStudentCourseRequest(studentCourseRelationDTO);

        assertEquals(studentCourseRelationDTO.getStudentId(), studentCourseRelationRequest.getStudentId());
        assertEquals(studentCourseRelationDTO.getCourseName(), studentCourseRelationRequest.getCourseName());
        assertEquals(studentCourseRelationDTO.getRating(), studentCourseRelationRequest.getRating());

    }
}