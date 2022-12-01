package com.example.StudentPerformance.dto;

import com.example.StudentPerformance.entity.Course;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LessonData {

    @JsonProperty("Course")
    private Course course;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Data")
    private Data data;

}
