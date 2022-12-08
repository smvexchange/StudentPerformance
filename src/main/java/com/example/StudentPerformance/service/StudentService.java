package com.example.StudentPerformance.service;

import com.example.StudentPerformance.dto.CourseRatingKeyDto;
import com.example.StudentPerformance.dto.StudentDto;
import com.example.StudentPerformance.entity.Course;
import com.example.StudentPerformance.entity.CourseRating;
import com.example.StudentPerformance.entity.CourseRatingKey;
import com.example.StudentPerformance.entity.Student;
import com.example.StudentPerformance.mapper.CourseMapper;
import com.example.StudentPerformance.mapper.CourseRatingKeyMapper;
import com.example.StudentPerformance.mapper.CourseRatingMapper;
import com.example.StudentPerformance.mapper.StudentMapper;
import com.example.StudentPerformance.repository.CourseRatingRepository;
import com.example.StudentPerformance.repository.CourseRepository;
import com.example.StudentPerformance.repository.StudentRepository;
import com.example.StudentPerformance.web.exception.NotFoundException;
import com.example.StudentPerformance.web.response.BaseResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StudentService {

    private final StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
    private final CourseMapper courseMapper = Mappers.getMapper(CourseMapper.class);
    private final CourseRatingKeyMapper courseRatingKeyMapper = Mappers.getMapper(CourseRatingKeyMapper.class);

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseRatingRepository courseRatingRepository;
    private final StudentPerformanceService studentPerformanceService;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, CourseRatingRepository courseRatingRepository, StudentPerformanceService studentPerformanceService) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.courseRatingRepository = courseRatingRepository;
        this.studentPerformanceService = studentPerformanceService;
    }

    public BaseResponse createStudent(StudentDto studentDto) {
        Student studentEntity = studentMapper.dtoToEntity(studentDto);
        studentRepository.save(studentEntity);
        return new BaseResponse(HttpStatus.OK.value(), "Student successfully created.");
    }

    public BaseResponse updateStudent(StudentDto studentDto) {
        if (studentDto.getId() == null) {
            throw new NotFoundException("Student`s id must not be null.");
        }
        Student studentById = studentRepository.findById(studentDto.getId()).orElseThrow(
                () -> new NotFoundException("Student with id " + studentDto.getId() + " not found."));
        studentMapper.updateStudentFromDto(studentDto, studentById);
        studentRepository.save(studentById);
        return new BaseResponse(HttpStatus.OK.value(), "Student successfully updated.");
    }

    public BaseResponse linkToCourse(CourseRatingKeyDto courseRatingKeyDto) {
        if (courseRatingKeyDto.getStudent_id() == null  || courseRatingKeyDto.getCourse_id() == null) {
            throw new NotFoundException("Student_id and course_id must not be null.");
        }
        CourseRatingKey courseRatingKey = courseRatingKeyMapper.dtoToEntity(courseRatingKeyDto);
        Student studentById = studentRepository.findById(courseRatingKeyDto.getStudent_id()).orElseThrow(
                () -> new NotFoundException("Student with id " + courseRatingKeyDto.getStudent_id() + " not found."));
        Course courseById = courseRepository.findById(courseRatingKeyDto.getCourse_id()).orElseThrow(
                () -> new NotFoundException("Course with id " + courseRatingKeyDto.getCourse_id() + " not found."));
        CourseRating courseRating = new CourseRating();
        courseRating.setId(courseRatingKey);
        courseRating.setRating(studentPerformanceService.calculateStudentRating(
                courseRatingKeyDto.getStudent_id(),
                courseRatingKeyDto.getCourse_id()));
        courseRating.setPassed(courseRating.getRating().compareTo(BigDecimal.valueOf(0.7)) < 0);
        courseRatingRepository.save(courseRating);

        return new BaseResponse(HttpStatus.OK.value(), "Student successfully linked to course.");
    }

    public StudentDto getStudentInfo(Long id) {
        if (id == 0) {
            throw new NotFoundException("Student`s id must not be null.");
        }
        Student studentById = studentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Student with id " + id + " not found."));
        return studentMapper.entityToDto(studentById);
    }
}
