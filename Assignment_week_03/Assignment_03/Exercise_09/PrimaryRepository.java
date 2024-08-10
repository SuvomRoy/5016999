package com.example.primary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.primary.model.Employee;

public interface PrimaryRepository extends JpaRepository<Employee, Long> {
}
