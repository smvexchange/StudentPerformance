package com.example.StudentPerformance.controller;

import com.example.StudentPerformance.dto.StudentDto;
import com.example.StudentPerformance.service.StudentService;
import com.example.StudentPerformance.web.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/create",
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @PostMapping(
            value = "/update",
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateStudent(@RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentDto);
    }


}
