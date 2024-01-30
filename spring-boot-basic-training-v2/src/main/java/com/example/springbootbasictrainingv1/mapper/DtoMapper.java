package com.example.springbootbasictrainingv1.mapper;

import com.example.springbootbasictrainingv1.DTO.StudentResponseDTO;
import com.example.springbootbasictrainingv1.model.Student;

public class DtoMapper {
    public static StudentResponseDTO convertToDto(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getDateOfBirth(),
                student.getAverage()
        );
    }
}
