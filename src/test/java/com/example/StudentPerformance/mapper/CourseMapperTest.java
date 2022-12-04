package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.CourseDto;
import com.example.StudentPerformance.entity.Course;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseMapperTest {

    private final CourseMapper mapper = Mappers.getMapper(CourseMapper.class);

    @Test
    void courseToCourseDto() {
        Course course = new Course();
        course.setName("JAVA");
        course.setStartDate(new Date());
        course.setEndDate(new Date());
        CourseDto courseDTO = mapper.entityToDto(course);

        assertEquals(course.getName(), courseDTO.getName());
        assertEquals(course.getStartDate(), courseDTO.getStartDate());
        assertEquals(course.getEndDate(), courseDTO.getEndDate());
    }

    @Test
    void courseDtoToCourse() {
        CourseDto courseDTO = new CourseDto();
        courseDTO.setName("JAVA");
        courseDTO.setStartDate(new Date());
        courseDTO.setEndDate(new Date());
        Course course = mapper.dtoToEntity(courseDTO);

        assertEquals(courseDTO.getName(), course.getName());
        assertEquals(courseDTO.getStartDate(), course.getStartDate());
        assertEquals(courseDTO.getEndDate(), course.getEndDate());
    }
}