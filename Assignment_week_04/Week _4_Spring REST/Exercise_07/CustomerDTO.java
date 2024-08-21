package com.example.bookstoreapi.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String password; // Be cautious with passwords, consider not exposing them directly
}
