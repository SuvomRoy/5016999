package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll(); // Ensure database is empty before each test
    }

    @Test
    public void testCreateBook() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Test Book");
        bookDTO.setAuthor("Test Author");
        bookDTO.setPrice(19.99);
        bookDTO.setIsbn("1234567890");

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test Book"))
                .andExpect(jsonPath("$.author").value("Test Author"));
    }

    @Test
    public void testGetBookById() throws Exception {
        Book book = new Book();
        book.setTitle("Existing Book");
        book.setAuthor("Existing Author");
        book.setPrice(29.99);
        book.setIsbn("0987654321");
        bookRepository.save(book);

        mockMvc.perform(get("/books/{id}", book.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Existing Book"))
                .andExpect(jsonPath("$.author").value("Existing Author"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book book = new Book();
        book.setTitle("Old Title");
        book.setAuthor("Old Author");
        book.setPrice(29.99);
        book.setIsbn("0987654321");
        bookRepository.save(book);

        BookDTO updatedBookDTO = new BookDTO();
        updatedBookDTO.setTitle("Updated Title");
        updatedBookDTO.setAuthor("Updated Author");
        updatedBookDTO.setPrice(19.99);
        updatedBookDTO.setIsbn("1234567890");

        mockMvc.perform(put("/books/{id}", book.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBookDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Title"))
                .andExpect(jsonPath("$.author").value("Updated Author"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book book = new Book();
        book.setTitle("Book to Delete");
        book.setAuthor("Author");
        book.setPrice(29.99);
        book.setIsbn("0987654321");
        bookRepository.save(book);

        mockMvc.perform(delete("/books/{id}", book.getId()))
                .andExpect(status().isNoContent());
    }
}
