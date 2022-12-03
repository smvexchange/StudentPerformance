package com.example.StudentPerformance.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(targetEntity = Lesson.class, fetch = FetchType.EAGER)
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "course")
    private List<CourseRating> ratings;

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
