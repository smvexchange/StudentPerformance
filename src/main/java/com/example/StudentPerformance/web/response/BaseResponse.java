package com.example.StudentPerformance.web.response;

import lombok.Data;

@Data
public class BaseResponse {
    private int statusCode;
    private String message;

    public BaseResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
