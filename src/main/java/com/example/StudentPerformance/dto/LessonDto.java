package com.example.StudentPerformance.dto;

import com.example.StudentPerformance.entity.Course;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class LessonDto {

    @JsonProperty("course")
    private Course course;

    @JsonProperty("name")
    private String name;

    @JsonProperty("data")
    private Date date;

}
