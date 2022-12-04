package com.example.StudentPerformance.web.handler;

import com.example.StudentPerformance.web.exception.NotFoundException;
import com.example.StudentPerformance.web.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BaseResponse> catchResourceNotFoundException(NotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(new BaseResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}