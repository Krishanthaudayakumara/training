package com.example.springbootbasictrainingv1.controller;
import com.example.springbootbasictrainingv1.DTO.StudentRequestDTO;
import com.example.springbootbasictrainingv1.DTO.StudentResponseDTO;
import com.example.springbootbasictrainingv1.exception.ResourceNotFoundException;
import com.example.springbootbasictrainingv1.mapper.DtoMapper;
import com.example.springbootbasictrainingv1.model.Student;
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
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable String id) {
        try {
            StudentResponseDTO studentResponseDTO = studentService.getStudentById(id);
            return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequest) {
        try {
            StudentResponseDTO studentResponseDTO = studentService.createStudent(studentRequest);
            return new ResponseEntity<>(studentResponseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        try {
            String message = studentService.deleteStudent(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}