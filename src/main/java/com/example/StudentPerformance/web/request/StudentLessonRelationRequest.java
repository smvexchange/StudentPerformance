package com.example.StudentPerformance.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentLessonRelationRequest {
    private Long studentId;
    private Long lessonId;
    private double grade;
}
