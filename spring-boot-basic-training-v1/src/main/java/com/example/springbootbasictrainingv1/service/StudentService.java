package com.example.springbootbasictrainingv1.service;

import com.example.springbootbasictrainingv1.DTO.StudentRequestDTO;
import com.example.springbootbasictrainingv1.DTO.StudentResponseDTO;
import com.example.springbootbasictrainingv1.exception.ResourceNotFoundException;
import com.example.springbootbasictrainingv1.mapper.DtoMapper;
import com.example.springbootbasictrainingv1.model.Student;
import com.example.springbootbasictrainingv1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentResponseDTO getStudentById(String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return DtoMapper.convertToDto(student);
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequest) {
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
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }
}