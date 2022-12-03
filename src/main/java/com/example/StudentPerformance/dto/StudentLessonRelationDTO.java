package com.example.StudentPerformance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentLessonRelationDTO {

    @JsonProperty("student_id")
    private Long studentId;

    @JsonProperty("lesson_id")
    private Long lessonId;

    @JsonProperty("grade")
    private double grade;
}
