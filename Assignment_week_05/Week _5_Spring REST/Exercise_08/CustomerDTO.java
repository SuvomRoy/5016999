package com.example.bookstoreapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CustomerDTO {
    private Long id;
    
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name should not exceed 100 characters")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
    
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password should be at least 6 characters long")
    private String password;
}
