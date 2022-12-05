package com.example.StudentPerformance.controller;


import com.example.StudentPerformance.dto.LessonDto;
import com.example.StudentPerformance.service.LessonService;
import com.example.StudentPerformance.web.response.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping(value = "/create",
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse createLesson(@RequestBody LessonDto lessonDto) {
        return lessonService.createLesson(lessonDto);
    }

    @PostMapping(
            value = "/update",
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateLesson(@RequestBody LessonDto lessonDto) {
        return lessonService.updateLesson(lessonDto);
    }
}
