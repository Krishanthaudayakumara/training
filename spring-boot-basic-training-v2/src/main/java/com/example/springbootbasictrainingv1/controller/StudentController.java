package com.example.springbootbasictrainingv1.controller;
import com.example.springbootbasictrainingv1.DTO.StudentRequestDTO;
import com.example.springbootbasictrainingv1.DTO.StudentResponseDTO;
import com.example.springbootbasictrainingv1.exception.ResourceNotFoundException;
import com.example.springbootbasictrainingv1.mapper.DtoMapper;
import com.example.springbootbasictrainingv1.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springbootbasictrainingv1.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(StudentController.class);


    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        try {
            List<StudentResponseDTO> students = studentService.getAllStudents()
                    .stream()
                    .map(DtoMapper::convertToDto)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error fetching all students", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable("id") String studentId) {
        try {
            StudentResponseDTO studentResponseDTO = studentService.getStudentById(studentId);
            return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            logger.warn("Student not found by ID: {}", studentId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error fetching student by ID: {}", studentId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequest) {
        try {
            StudentResponseDTO studentResponseDTO = studentService.createStudent(studentRequest);
            return new ResponseEntity<>(studentResponseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error creating a new student", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        try {
            String message = studentService.deleteStudent(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            logger.warn("Student not found by ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error deleting student by ID: {}", id, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}