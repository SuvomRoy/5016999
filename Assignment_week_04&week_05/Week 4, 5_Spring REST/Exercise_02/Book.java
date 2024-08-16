package com.example.bookstoreapi.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn; // Added ISBN attribute
}
