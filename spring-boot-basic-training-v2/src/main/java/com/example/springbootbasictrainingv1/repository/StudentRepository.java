package com.example.springbootbasictrainingv1.repository;

import com.example.springbootbasictrainingv1.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
