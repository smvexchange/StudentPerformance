package com.example.StudentPerformance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CourseData {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Start date")
    private Date startDate;

    @JsonProperty("End date")
    private Date endDate;

}
