package com.example.StudentPerformance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LESSON_GRADE")
@Getter
@Setter
@NoArgsConstructor
public class LessonGrade {

    @EmbeddedId
    private LessonGradeKey id;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student")
    private Student student;

    @ManyToOne
    @MapsId("lesson_id")
    @JoinColumn(name = "lesson")
    private Lesson lesson;

    @Column(name = "grade")
    private double grade;
}
