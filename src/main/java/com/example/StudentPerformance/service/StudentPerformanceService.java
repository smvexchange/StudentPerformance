package com.example.StudentPerformance.service;

import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.Lesson;
import com.example.StudentPerformance.entity.LessonGrade;
import com.example.StudentPerformance.repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class StudentPerformanceService {

    private final CourseRepository courseRepository;
    private final LessonGradeRepository lessonGradeRepository;

    public StudentPerformanceService(CourseRepository courseRepository, LessonGradeRepository lessonGradeRepository) {
        this.courseRepository = courseRepository;
        this.lessonGradeRepository = lessonGradeRepository;
    }


    private double getSumOfMaxLessonGrades(Long courseId) throws NoSuchElementException {
        Optional<Course> courseById = courseRepository.findById(courseId);
        List<Lesson> lessons = courseById.orElseThrow(NoSuchElementException::new).getLessons();
        return lessons.stream().mapToDouble(Lesson::getMaxGrade).sum();
    }

    private double getSumOfStudentGrades(Long studentId) {
        List<LessonGrade> gradeRepositoryAll = lessonGradeRepository.findAll();
        List<LessonGrade> lessonGradeByStudentId = gradeRepositoryAll.stream()
                .filter(lessonGrade -> Objects.equals(lessonGrade.getStudent().getId(), studentId))
                .filter(lessonGrade -> (lessonGrade.getLesson().getDate().getTime() - new Date().getTime()) < 0)
                .toList();
        return lessonGradeByStudentId.stream().mapToDouble(LessonGrade::getGrade).sum();
    }

    public BigDecimal calculateStudentRating(Long studentId, Long courseId) {
        return BigDecimal
                .valueOf(getSumOfStudentGrades(studentId) / getSumOfMaxLessonGrades(courseId))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
