package com.example.StudentPerformance.controller;

import com.example.StudentPerformance.entity.Student;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PostMapping(
            value = "/createStudent", consumes = "application/json", produces = "application/json")
    public Student createStudent(@RequestBody Student student) {
        return null;
    }

    @PostMapping(
            value = "/updateStudent", consumes = "application/json", produces = "application/json")
    public Student updateStudent(@RequestBody Student person, HttpServletResponse response) {
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/findPerson/" + person.getId()).toUriString());

        return null;
    }
}
