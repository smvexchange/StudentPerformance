package com.example.StudentPerformance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "COURSE_RATINGS")
@Getter
@Setter
@NoArgsConstructor
public class CourseRating {

    @EmbeddedId
    private CourseRatingKey id;

    @ManyToOne
    @MapsId("student")
    @JoinColumn(name = "student")
    private Student student;

    @ManyToOne
    @MapsId("course")
    @JoinColumn(name = "course")
    private Course course;

    @Column(name = "rating")
    @ColumnDefault("0.0")
    private BigDecimal rating;

    @Column(name = "is_passed")
    @ColumnDefault("false")
    private boolean isPassed;
}
