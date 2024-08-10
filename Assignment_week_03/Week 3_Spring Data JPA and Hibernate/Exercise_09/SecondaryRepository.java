package com.example.secondary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.secondary.model.Department;

public interface SecondaryRepository extends JpaRepository<Department, Long> {
}
