package com.example.StudentPerformance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "STUDENTS")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty("last_name")
    private String lastName;

    @Column(name = "patronymic")
    @JsonProperty("patronymic")
    private String patronymic;

    @Column(name = "group_number", columnDefinition = "varchar(255) default 'no group'")
    @JsonProperty("group_number")
    private String groupNumber;

    @Column(name = "is_active", columnDefinition = "boolean default false")
    @JsonProperty("is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(name = "courses")
    @JsonProperty("courses")
    private List<CourseRating> courses;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(name = "lessons")
    @JsonProperty("lessons")
    private List<LessonGrade> lessonGrades;

    public void addLessonGrade(LessonGrade lessonGrade) {
        if (lessonGrades == null) {
            lessonGrades = new ArrayList<>();
            lessonGrades.add(lessonGrade);
        } else {
            lessonGrades.add(lessonGrade);
        }
    }

    public void addCourses(CourseRating courseRating) {
        if (courses == null) {
            courses = new ArrayList<>();
            courses.add(courseRating);
        } else {
            courses.add(courseRating);
        }
    }
    public Student(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(patronymic, student.patronymic) && Objects.equals(groupNumber, student.groupNumber) && Objects.equals(isActive, student.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, patronymic, groupNumber, isActive);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                ", isActive=" + isActive +
                ", grades=" + courses +
                '}';
    }
}
