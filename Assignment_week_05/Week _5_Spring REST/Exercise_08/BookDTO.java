package com.example.bookstoreapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookDTO {
    private Long id;
    
    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title should not exceed 255 characters")
    private String title;
    
    @NotBlank(message = "Author is mandatory")
    private String author;
    
    @NotNull(message = "Price is mandatory")
    private double price;
    
    @NotBlank(message = "ISBN is mandatory")
    private String isbn;
}
