package com.example.StudentPerformance.dto;

import com.example.StudentPerformance.entity.CourseRating;
import com.example.StudentPerformance.entity.LessonGrade;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("patronymic")
    private String patronymic;

    @JsonProperty("group_number")
    private String groupNumber;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("courses")
    private List<CourseRating> courses;

    @JsonProperty("lessons")
    private List<LessonGrade> lessons;
}
