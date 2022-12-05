package com.example.StudentPerformance.dto;

import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.CourseRatingKey;
import com.example.StudentPerformance.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CourseRatingDto {

    @JsonProperty("id")
    private CourseRatingKey id;

    @JsonProperty("student")
    private Student student;

    @JsonProperty("course")
    private Course course;

    @JsonProperty("rating")
    private double rating;

    @JsonProperty("is_Passed")
    private boolean isPassed;
}
