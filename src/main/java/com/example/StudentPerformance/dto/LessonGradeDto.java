package com.example.StudentPerformance.dto;

import com.example.StudentPerformance.entity.Lesson;
import com.example.StudentPerformance.entity.LessonGradeKey;
import com.example.StudentPerformance.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LessonGradeDto {

    @JsonProperty("id")
    private LessonGradeKey id;

    @JsonProperty("student")
    private Student student;

    @JsonProperty("lesson")
    private Lesson lesson;

    @JsonProperty("grade")
    private double grade;
}
