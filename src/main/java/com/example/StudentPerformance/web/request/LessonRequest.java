package com.example.StudentPerformance.web.request;

import com.example.StudentPerformance.entity.Course;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class LessonRequest {
    private Course course;
    private String name;
    private Date data;
}
