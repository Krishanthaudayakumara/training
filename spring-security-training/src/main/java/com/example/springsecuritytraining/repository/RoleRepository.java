package com.example.springsecuritytraining.repository;

import com.example.springsecuritytraining.model.ERole;
import com.example.springsecuritytraining.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}