package com.example.StudentPerformance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "STUDENTS")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String patronymic;

    @Column
    private String groupNumber;

    @Column
    private Boolean isActive;

    @OneToOne(targetEntity = Course.class)
    private Course course;

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
}
