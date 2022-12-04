package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.StudentDto;
import com.example.StudentPerformance.entity.Student;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentMapperTest {

    private final StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    @Test
    void studentRequestToStudentDto() {
        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");
        student.setPatronymic("Ivanovish");
        StudentDto studentDTO = mapper.entityToDto(student);

        assertEquals(student.getFirstName(), studentDTO.getFirstName());
        assertEquals(student.getLastName(), studentDTO.getLastName());
        assertEquals(student.getPatronymic(), studentDTO.getPatronymic());
    }

    @Test
    void studentDtoToStudentRequest() {
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName("Dmitriy");
        studentDto.setLastName("Komov");
        studentDto.setPatronymic("Fedorovich");
        Student student = mapper.dtoToEntity(studentDto);

        assertEquals(studentDto.getFirstName(), student.getFirstName());
        assertEquals(studentDto.getLastName(), student.getLastName());
        assertEquals(studentDto.getPatronymic(), student.getPatronymic());
    }
}