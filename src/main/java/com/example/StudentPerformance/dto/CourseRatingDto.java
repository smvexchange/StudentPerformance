package com.example.StudentPerformance.dto;

import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CourseRatingDto {

    @JsonProperty("student_id")
    private Student student;

    @JsonProperty("course_name")
    private Course course;

    @JsonProperty("rating")
    private double rating;

    @JsonProperty("is_Passed")
    private boolean isPassed;
}
