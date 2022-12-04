package com.example.StudentPerformance.repository;

import com.example.StudentPerformance.entity.LessonGrade;
import com.example.StudentPerformance.entity.LessonGradeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonGradeRepository extends JpaRepository<LessonGrade, Long> {
    List<LessonGrade> findAllById(LessonGradeKey id);
}
