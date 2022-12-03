package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.CourseDTO;
import com.example.StudentPerformance.web.request.CourseRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CourseMapperTest {

    private final CourseMapper mapper = Mappers.getMapper(CourseMapper.class);

    @Test
    void courseRequestToCourseDto() {
        CourseRequest courseRequest = new CourseRequest();
        courseRequest.setName("JAVA");
        courseRequest.setStartDate(new Date());
        courseRequest.setEndDate(new Date());
        CourseDTO courseDTO = mapper.courseRequestToCourseDto(courseRequest);

        assertEquals(courseRequest.getName(), courseDTO.getName());
        assertEquals(courseRequest.getStartDate(), courseDTO.getStartDate());
        assertEquals(courseRequest.getEndDate(), courseDTO.getEndDate());
    }

    @Test
    void courseDtoToCourseRequest() {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName("JAVA");
        courseDTO.setStartDate(new Date());
        courseDTO.setEndDate(new Date());
        CourseRequest courseRequest = mapper.courseDtoToCourseRequest(courseDTO);

        assertEquals(courseDTO.getName(), courseRequest.getName());
        assertEquals(courseDTO.getStartDate(), courseRequest.getStartDate());
        assertEquals(courseDTO.getEndDate(), courseRequest.getEndDate());
    }
}