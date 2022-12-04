package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.StudentDto;
import com.example.StudentPerformance.entity.Student;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentFromDto(StudentDto studentDto, @MappingTarget Student student);

    StudentDto entityToDto(Student student);

    Student dtoToEntity(StudentDto studentDto);
}
