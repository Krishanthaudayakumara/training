package com.example.springbootbasictrainingv1.service;

import com.example.springbootbasictrainingv1.DTO.StudentRequestDTO;
import com.example.springbootbasictrainingv1.DTO.StudentResponseDTO;
import com.example.springbootbasictrainingv1.exception.ResourceNotFoundException;
import com.example.springbootbasictrainingv1.mapper.DtoMapper;
import com.example.springbootbasictrainingv1.model.Student;
import com.example.springbootbasictrainingv1.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);


    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return studentRepository.findAll();
    }

    public StudentResponseDTO getStudentById(String id) {
        logger.info("Fetching student by ID: {}", id);
        Optional<Student> studentOptional = studentRepository.findById(id);
        Student student = studentOptional.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return DtoMapper.convertToDto(student);
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequest) {
        logger.info("Creating a new student");
        // StudentRequestDTO to Student entity
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setDateOfBirth(studentRequest.getDateOfBirth());
        student.setAverage(studentRequest.getAverage());

        studentRepository.save(student);

        // Student to StudentResponseDTO
        return DtoMapper.convertToDto(student);
    }

    public String deleteStudent(String id) {
        logger.info("Deleting student by ID: {}", id);

        Optional<Student> existingStudentOptional = studentRepository.findById(id);
        Student existingStudent = existingStudentOptional.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }
}