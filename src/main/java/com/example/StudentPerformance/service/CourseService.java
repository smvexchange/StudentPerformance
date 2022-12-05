package com.example.StudentPerformance.service;

import com.example.StudentPerformance.dto.CourseDto;
import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.mapper.CourseMapper;
import com.example.StudentPerformance.repository.CourseRepository;
import com.example.StudentPerformance.web.exception.NotFoundException;
import com.example.StudentPerformance.web.response.BaseResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseMapper mapper = Mappers.getMapper(CourseMapper.class);

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public BaseResponse createCourse(CourseDto courseDto) {
        Course courseEntity = mapper.dtoToEntity(courseDto);
        courseRepository.save(courseEntity);
        return new BaseResponse(HttpStatus.OK.value(), "Course successfully created.");
    }

    public BaseResponse updateCourse(CourseDto courseDto) {
        if (courseDto.getId() == null) {
            throw new NotFoundException("Course`s id must not be null.");
        }
        Course courseById = courseRepository.findById(courseDto.getId()).orElseThrow(
                () -> new NotFoundException("Course with id " + courseDto.getId() + " not found."));
        mapper.updateCourseFromDto(courseDto, courseById);
        courseRepository.save(courseById);
        return new BaseResponse(HttpStatus.OK.value(), "Student successfully updated.");
    }
}
