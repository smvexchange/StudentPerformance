package com.example.StudentPerformance.repository;

import com.example.StudentPerformance.entity.Lesson;
import com.example.StudentPerformance.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LessonRepositoryTest {

    @Autowired
    private LessonRepository lessonRepository;

    @Test
    public void testRepo() {
        for (int i = 0; i < 10; i++) {
            lessonRepository.save(new Lesson());
        }
        final List<Lesson> found = lessonRepository.findAll();
        assertEquals(10, found.size());
    }
}