package com.example.StudentPerformance.repository;

import com.example.StudentPerformance.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testRepo() {
        for (int i = 0; i < 10; i++) {
            studentRepository.save(new Student());
        }
        final List<Student> found = (List<Student>) studentRepository.findAll();
        assertEquals(10, found.size());
    }
}