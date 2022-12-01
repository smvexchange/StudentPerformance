package com.example.StudentPerformance.repository;

import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
