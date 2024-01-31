package com.example.springbootbasictrainingv1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class StudentResponseDTO {
    private String id;
    private String name;
    private Date dateOfBirth;
    private double average;
}