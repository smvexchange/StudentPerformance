package com.example.StudentPerformance.dto;

import com.example.StudentPerformance.entity.CourseRating;
import com.example.StudentPerformance.entity.Lesson;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CourseDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("start_date")
    private Date startDate;

    @JsonProperty("end_date")
    private Date endDate;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("lessons")
    private List<Lesson> lessons;

    @JsonProperty("ratings")
    private List<CourseRating> ratings;
}
