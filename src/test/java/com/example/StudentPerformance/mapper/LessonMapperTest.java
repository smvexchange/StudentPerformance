package com.example.StudentPerformance.mapper;

import com.example.StudentPerformance.dto.LessonDto;
import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.Lesson;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LessonMapperTest {

    private final LessonMapper mapper = Mappers.getMapper(LessonMapper.class);

    @Test
    void lessonToLessonDto() {
        Lesson lesson = new Lesson();
        lesson.setName("Core");
        lesson.setDate(new Date());
        lesson.setCourse(new Course());
        LessonDto lessonDTO = mapper.entityToDto(lesson);

        assertEquals(lesson.getName(), lessonDTO.getName());
        assertEquals(lesson.getDate(), lessonDTO.getDate());
        assertEquals(lesson.getCourse(), lessonDTO.getCourse());
    }

    @Test
    void lessonDtoToLesson() {
        LessonDto lessonDto = new LessonDto();
        lessonDto.setName("Core");
        lessonDto.setDate(new Date());
        lessonDto.setCourse(new Course());
        Lesson lesson = mapper.dtoToEntity(lessonDto);

        assertEquals(lessonDto.getName(), lesson.getName());
        assertEquals(lessonDto.getDate(), lesson.getDate());
        assertEquals(lessonDto.getCourse(), lesson.getCourse());
    }
}