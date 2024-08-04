// src/main/java/com/library/repository/BookRepository.java
package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void performRepositoryTask() {
        System.out.println("Repository task is being performed.");
    }
}
