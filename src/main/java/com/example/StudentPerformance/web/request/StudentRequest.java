package com.example.StudentPerformance.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String patronymic;
}
