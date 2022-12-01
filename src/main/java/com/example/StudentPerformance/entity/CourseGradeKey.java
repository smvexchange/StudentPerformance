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
public class CourseGradeKey implements Serializable {

    @Column(name = "student_id")
    private Long student_id;

    @Column(name = "course_name")
    private String course_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseGradeKey that = (CourseGradeKey) o;
        return Objects.equals(student_id, that.student_id) && Objects.equals(course_name, that.course_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, course_name);
    }
}
