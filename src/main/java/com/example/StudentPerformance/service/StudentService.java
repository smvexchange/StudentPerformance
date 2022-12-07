package com.example.StudentPerformance.service;

import com.example.StudentPerformance.dto.StudentDto;
import com.example.StudentPerformance.entity.Student;
import com.example.StudentPerformance.mapper.StudentMapper;
import com.example.StudentPerformance.repository.StudentRepository;
import com.example.StudentPerformance.web.exception.NotFoundException;
import com.example.StudentPerformance.web.response.BaseResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public BaseResponse createStudent(StudentDto studentDto) {
        Student studentEntity = mapper.dtoToEntity(studentDto);
        studentRepository.save(studentEntity);
        return new BaseResponse(HttpStatus.OK.value(), "Student successfully created.");
    }

    public BaseResponse updateStudent(StudentDto studentDto) {
        if (studentDto.getId() == null) {
            throw new NotFoundException("Student`s id must not be null.");
        }
        Student studentById = studentRepository.findById(studentDto.getId()).orElseThrow(
                () -> new NotFoundException("Student with id " + studentDto.getId() + " not found."));
        mapper.updateStudentFromDto(studentDto, studentById);
        studentRepository.save(studentById);
        return new BaseResponse(HttpStatus.OK.value(), "Student successfully updated.");
    }

    public BaseResponse linkToCourse(StudentDto studentDto) {
        if (studentDto.getId() == null) {
            throw new NotFoundException("Student`s id must not be null.");
        }
        Student studentById = studentRepository.findById(studentDto.getId()).orElseThrow(
                () -> new NotFoundException("Student with id " + studentDto.getId() + " not found."));
        mapper.updateStudentFromDto(studentDto, studentById);
        studentRepository.save(studentById);
        return new BaseResponse(HttpStatus.OK.value(), "Student successfully updated.");
    }
}
