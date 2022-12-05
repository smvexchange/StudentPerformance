package com.example.StudentPerformance.dto;

import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.LessonGrade;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class LessonDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("course")
    private Course course;

    @JsonProperty("name")
    private String name;

    @JsonProperty("data")
    private Date date;

    @JsonProperty("max_grade")
    private Integer maxGrade;

    @JsonProperty("grades")
    private List<LessonGrade> grades;
}
