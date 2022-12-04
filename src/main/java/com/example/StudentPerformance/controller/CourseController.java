package com.example.StudentPerformance.controller;

import com.example.StudentPerformance.dto.CourseDto;
import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.mapper.CourseMapper;
import com.example.StudentPerformance.repository.CourseRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    private final CourseMapper mapper = Mappers.getMapper(CourseMapper.class);


    @PostMapping(value = "/create",
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCourse(@RequestBody CourseDto courseDto) {
        Course course = mapper.dtoToEntity(courseDto);
        courseRepository.save(course);
        return ResponseEntity.ok("New course added.");
    }

    @PostMapping(
            value = "/update",
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCourse(@RequestBody CourseDto courseDto) {
        if (courseDto.getId() == null) {
            throw new IllegalArgumentException("Course ID mush not be null");
        }
        Course courseById = courseRepository.getReferenceById(courseDto.getId());
        mapper.updateCourseFromDto(courseDto, courseById);
        courseRepository.save(courseById);
        return ResponseEntity.ok("Course successfully updated");
    }
}
