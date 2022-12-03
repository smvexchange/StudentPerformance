package com.example.StudentPerformance.repository;

import com.example.StudentPerformance.entity.LessonGrade;
import com.example.StudentPerformance.entity.LessonGradeKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonGradeRepository extends CrudRepository<LessonGrade, Long> {
    List<LessonGrade> findAllById(LessonGradeKey id);
}
