package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.StudentDTO;
import com.example.StudentPerformance.web.request.StudentRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private final StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    @Test
    void studentRequestToStudentDto() {
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setFirstName("Ivan");
        studentRequest.setLastName("Ivanov");
        studentRequest.setPatronymic("Ivanovish");
        StudentDTO studentDTO = mapper.studentRequestToStudentDto(studentRequest);

        assertEquals(studentRequest.getFirstName(), studentDTO.getFirstName());
        assertEquals(studentRequest.getLastName(), studentDTO.getLastName());
        assertEquals(studentRequest.getPatronymic(), studentDTO.getPatronymic());
    }

    @Test
    void studentDtoToStudentRequest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName("Dmitriy");
        studentDTO.setLastName("Komov");
        studentDTO.setPatronymic("Fedorovich");
        StudentRequest studentRequest = mapper.studentDtoToStudentRequest(studentDTO);

        assertEquals(studentDTO.getFirstName(), studentRequest.getFirstName());
        assertEquals(studentDTO.getLastName(), studentRequest.getLastName());
        assertEquals(studentDTO.getPatronymic(), studentRequest.getPatronymic());
    }
}