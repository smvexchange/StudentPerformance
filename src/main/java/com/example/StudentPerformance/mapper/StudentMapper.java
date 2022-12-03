package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.StudentDTO;
import com.example.StudentPerformance.entity.Student;
import com.example.StudentPerformance.web.request.StudentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO studentRequestToStudentDto(StudentRequest studentRequest);

    StudentRequest studentDtoToStudentRequest(StudentDTO studentDTO);
}
