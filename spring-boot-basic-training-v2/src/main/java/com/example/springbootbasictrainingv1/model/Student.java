package com.example.springbootbasictrainingv1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Student {

    @Id
    private String id;
    private String name;
    private Date dateOfBirth;
    private double average;
}
