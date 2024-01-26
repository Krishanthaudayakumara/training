package com.example.springbootbasictrainingv1.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class StudentResponseDTO {
    private String id;
    private String name;
    private Date dateOfBirth;
    private double average;
}