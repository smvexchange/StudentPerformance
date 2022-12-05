package com.example.StudentPerformance.service;

import com.example.StudentPerformance.dto.LessonDto;
import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.Lesson;
import com.example.StudentPerformance.mapper.LessonMapper;
import com.example.StudentPerformance.repository.CourseRepository;
import com.example.StudentPerformance.repository.LessonRepository;
import com.example.StudentPerformance.web.exception.NotFoundException;
import com.example.StudentPerformance.web.response.BaseResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    private final LessonMapper mapper = Mappers.getMapper(LessonMapper.class);

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    public LessonService(LessonRepository lessonRepository, CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    public BaseResponse createLesson(LessonDto lessonDto) {
        if (lessonDto.getCourse() == null) {
            throw new NotFoundException("Lesson don`t have association with course.");
        }
        Lesson lessonEntity = mapper.dtoToEntity(lessonDto);
        Course course = lessonEntity.getCourse();
        if (course.getId() != null) {
            courseRepository.findById(course.getId()).ifPresent(element -> element.addLesson(lessonEntity));
            courseRepository.save(course);
            lessonRepository.save(lessonEntity);
            return new BaseResponse(HttpStatus.OK.value(), "Lesson successfully added to course with id: " + course.getId() + ".");
        } else {
            courseRepository.save(course);
            lessonRepository.save(lessonEntity);
            return new BaseResponse(HttpStatus.OK.value(), "Lesson and course successfully created.");
        }
    }

    public BaseResponse updateLesson(LessonDto lessonDto) {
        if (lessonDto.getId() == null) {
            throw new NotFoundException("Lesson`s id must not be null.");
        }
        Lesson lessonById = lessonRepository.findById(lessonDto.getId()).orElseThrow(
                () -> new NotFoundException("Lesson with id " + lessonDto.getId() + " not found."));
        mapper.updateLessonFromDto(lessonDto, lessonById);
        lessonRepository.save(lessonById);
        return new BaseResponse(HttpStatus.OK.value(), "Lesson successfully updated.");
    }
}
