package com.example.StudentPerformance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class LessonGradeKey implements Serializable {

    @Column(name = "student_id")
    private Long student_id;

    @Column(name = "lesson_id")
    private Long lesson_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonGradeKey that = (LessonGradeKey) o;
        return Objects.equals(student_id, that.student_id) && Objects.equals(lesson_id, that.lesson_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, lesson_id);
    }
}
