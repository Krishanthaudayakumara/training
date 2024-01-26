package com.example.springbootbasictrainingv1.mapper;

import com.example.springbootbasictrainingv1.DTO.StudentResponseDTO;
import com.example.springbootbasictrainingv1.model.Student;

public class DtoMapper {

    public static StudentResponseDTO convertToDto(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setDateOfBirth(student.getDateOfBirth());
        dto.setAverage(student.getAverage());

        return dto;
    }
}
