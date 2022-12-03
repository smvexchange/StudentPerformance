package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.LessonDTO;
import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.web.request.LessonRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class LessonMapperTest {

    private final LessonMapper mapper = Mappers.getMapper(LessonMapper.class);

    @Test
    void lessonRequestToLessonDTO() {
        LessonRequest lessonRequest = new LessonRequest();
        lessonRequest.setName("Core");
        lessonRequest.setData(new Date());
        lessonRequest.setCourse(new Course());
        LessonDTO lessonDTO = mapper.lessonRequestToLessonDTO(lessonRequest);

        assertEquals(lessonRequest.getName(), lessonDTO.getName());
        assertEquals(lessonRequest.getData(), lessonDTO.getData());
        assertEquals(lessonRequest.getCourse(), lessonDTO.getCourse());
    }

    @Test
    void lessonDtoToLessonRequest() {
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setName("Core");
        lessonDTO.setData(new Date());
        lessonDTO.setCourse(new Course());
        LessonRequest lessonRequest = mapper.lessonDtoToLessonRequest(lessonDTO);

        assertEquals(lessonDTO.getName(), lessonRequest.getName());
        assertEquals(lessonDTO.getData(), lessonRequest.getData());
        assertEquals(lessonDTO.getCourse(), lessonRequest.getCourse());
    }
}