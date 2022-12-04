package com.example.StudentPerformance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COURSE_RATINGS")
@Getter
@Setter
@NoArgsConstructor
public class CourseRating {

    @EmbeddedId
    private CourseRatingKey id;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("course_name")
    @JoinColumn(name = "course_name")
    private Course course;

    @Column(name = "rating")
    private double rating;

    @Column(name = "is_Passed")
    private boolean isPassed;
}
