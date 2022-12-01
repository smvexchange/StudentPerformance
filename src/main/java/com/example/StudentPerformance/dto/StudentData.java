package com.example.StudentPerformance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentData {
    @JsonProperty("First name")
    private String firstName;

    @JsonProperty("Last name")
    private String lastName;

    @JsonProperty("Patronymic")
    private String patronymic;
}
