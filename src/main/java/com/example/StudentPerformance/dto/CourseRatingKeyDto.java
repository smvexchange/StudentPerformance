package com.example.StudentPerformance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CourseRatingKeyDto {
    @JsonProperty("student_id")
    private Long student_id;

    @JsonProperty("course_id")
    private Long course_id;
}
