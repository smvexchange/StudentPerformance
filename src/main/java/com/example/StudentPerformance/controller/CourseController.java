package com.example.StudentPerformance.controller;

import com.example.StudentPerformance.dto.CourseDto;
import com.example.StudentPerformance.service.CourseService;
import com.example.StudentPerformance.web.response.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(value = "/create",
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse createCourse(@RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }

    @PostMapping(
            value = "/update",
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateCourse(@RequestBody CourseDto courseDto) {
        return courseService.updateCourse(courseDto);
    }
}
