package com.example.StudentPerformance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COURSE_GRADE")
@Getter
@Setter
@NoArgsConstructor
public class CourseGrade {

    @EmbeddedId
    private CourseGradeKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("course_name")
    @JoinColumn(name = "course_name")
    private Course course;

    private int grade;
}
