package com.example.StudentPerformance.web.request;

import lombok.Data;

import java.util.Date;

@Data
public class CourseRequest {
    private String name;
    private Date startDate;
    private Date endDate;

}
