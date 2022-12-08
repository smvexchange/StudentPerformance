package com.example.StudentPerformance.entity;


import com.example.StudentPerformance.dto.LessonDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "COURSES")
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private Boolean isActive;

    @OneToMany(targetEntity = Lesson.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "course")
    private List<CourseRating> ratings;

    public void addLesson(Lesson lesson) {
        if (lessons == null) {
            lessons = new ArrayList<>();
            lessons.add(lesson);
        } else {
            lessons.add(lesson);
        }
    }

    public void addRating(CourseRating courseRating) {
        if (ratings == null) {
            ratings = new ArrayList<>();
            ratings.add(courseRating);
        } else {
            ratings.add(courseRating);
        }
    }

    public Course(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) && Objects.equals(startDate, course.startDate) && Objects.equals(endDate, course.endDate) && Objects.equals(isActive, course.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate, endDate, isActive);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isActive=" + isActive +
                ", lessons=" + lessons +
                ", grades=" + ratings +
                '}';
    }
}
