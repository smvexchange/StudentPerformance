package com.example.StudentPerformance.entity;


import com.example.StudentPerformance.dto.LessonDto;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private Long id;

    @Column(name = "name", unique = true)
    @JsonProperty("name")
    private String name;

    @Column(name = "start_date")
    @JsonProperty("start_date")
    private Date startDate;

    @Column(name = "end_date")
    @JsonProperty("end_date")
    private Date endDate;

    @Column(name = "is_active")
    @JsonProperty("is_active")
    private Boolean isActive;

    @OneToMany(targetEntity = Lesson.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("lessons")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "course")
    @JsonProperty("ratings")
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isActive=" + isActive +
                ", lessons=" + lessons +
                ", ratings=" + ratings +
                '}';
    }
}
