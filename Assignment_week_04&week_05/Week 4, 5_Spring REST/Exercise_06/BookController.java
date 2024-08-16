import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

// POST a new book with validation
@PostMapping
public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
    Book savedBook = bookRepository.save(book);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Custom-Header", "Value");
    return ResponseEntity.status(HttpStatus.CREATED)
            .headers(headers)
            .body(savedBook);
}

// PUT update an existing book with validation
@PutMapping("/{id}")
public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
    if (!bookRepository.existsById(id)) {
        throw new BookNotFoundException("Book not found with ID: " + id);
    }
    book.setId(id);
    Book updatedBook = bookRepository.save(book);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Custom-Header", "Value");
    return ResponseEntity.ok()
            .headers(headers)
            .body(updatedBook);
}
