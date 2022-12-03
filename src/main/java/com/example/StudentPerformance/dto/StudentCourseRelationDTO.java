package com.example.StudentPerformance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentCourseRelationDTO {

    @JsonProperty("student_id")
    private Long studentId;

    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("rating")
    private double rating;
}
