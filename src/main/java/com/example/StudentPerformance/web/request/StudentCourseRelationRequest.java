package com.example.StudentPerformance.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentCourseRelationRequest {
    private Long studentId;
    private String courseName;
    private double rating;
}
