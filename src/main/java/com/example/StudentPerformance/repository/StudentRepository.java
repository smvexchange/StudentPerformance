package com.example.StudentPerformance.repository;

import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}