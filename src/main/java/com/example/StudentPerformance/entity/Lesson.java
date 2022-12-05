package com.example.StudentPerformance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "LESSONS")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (targetEntity = Course.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Course course;

    @Column
    private String name;

    @Column
    private Date date;

    @Column
    private Integer maxGrade;

    @OneToMany(mappedBy = "lesson")
    private List<LessonGrade> grades;

    public Lesson(Course course, String name, Date date) {
        this.course = course;
        this.name = name;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id) && Objects.equals(course, lesson.course) && Objects.equals(name, lesson.name) && Objects.equals(date, lesson.date) && Objects.equals(maxGrade, lesson.maxGrade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, name, date, maxGrade);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", course=" + course +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", grade=" + maxGrade +
                '}';
    }
}

