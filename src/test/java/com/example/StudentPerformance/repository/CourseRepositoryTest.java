package com.example.StudentPerformance.repository;

import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testRepo() {
        for (int i = 0; i < 10; i++) {
            courseRepository.save(new Course("Java-"+ i));
        }
        final List<Course> found = courseRepository.findAll();
        assertEquals(10, found.size());
    }
}