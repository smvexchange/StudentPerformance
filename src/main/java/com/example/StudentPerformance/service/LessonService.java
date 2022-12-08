package com.example.StudentPerformance.service;

import com.example.StudentPerformance.dto.LessonDto;
import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.CourseRating;
import com.example.StudentPerformance.entity.Lesson;
import com.example.StudentPerformance.entity.LessonGrade;
import com.example.StudentPerformance.mapper.LessonMapper;
import com.example.StudentPerformance.repository.CourseRepository;
import com.example.StudentPerformance.repository.LessonRepository;
import com.example.StudentPerformance.web.exception.NotFoundException;
import com.example.StudentPerformance.web.response.BaseResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        if (lessonDto.getCourse().getId() == null) {
            throw new NotFoundException("Lesson don`t have association with course.");
        }
        Lesson lessonEntity = mapper.dtoToEntity(lessonDto);
        Course course = courseRepository.findById(lessonEntity.getCourse().getId()).orElseThrow(NoSuchElementException::new);
        course.addLesson(lessonEntity);
        courseRepository.save(course);
        return new BaseResponse(HttpStatus.OK.value(), "Lesson successfully added to course with id: " + course.getId() + ".");
    }

    public BaseResponse updateLesson(LessonDto lessonDto) {
        if (lessonDto.getId() == null) {
            throw new NotFoundException("Lesson`s id must not be null.");
        }
        Course course = courseRepository.findById(lessonDto.getCourse().getId()).orElseThrow(NoSuchElementException::new);
        List<Lesson> lessons = course.getLessons();
        Lesson lessonById = lessonRepository.findById(lessonDto.getId()).orElseThrow(
                () -> new NotFoundException("Lesson with id " + lessonDto.getId() + " not found."));
        int index = lessons.indexOf(lessonById);
        mapper.updateLessonFromDto(lessonDto, lessonById);
        lessons.set(index, lessonById);
        courseRepository.save(course);
        return new BaseResponse(HttpStatus.OK.value(), "Lesson successfully updated.");
    }
}
