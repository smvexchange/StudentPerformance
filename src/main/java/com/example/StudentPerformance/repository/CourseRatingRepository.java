package com.example.StudentPerformance.repository;

import com.example.StudentPerformance.entity.CourseRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRatingRepository extends CrudRepository<CourseRating, Long> {
}
