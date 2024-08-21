import org.springframework.http.HttpHeaders;

// POST a new book with custom headers
@PostMapping
public ResponseEntity<Book> createBook(@RequestBody Book book) {
    Book savedBook = bookRepository.save(book);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Custom-Header", "Value");
    headers.add("Another-Header", "Another-Value");

    return ResponseEntity.status(HttpStatus.CREATED)
            .headers(headers)
            .body(savedBook);
}

// PUT update an existing book with custom headers
@PutMapping("/{id}")
public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
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
// DELETE a book by ID with custom headers
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    if (!bookRepository.existsById(id)) {
        throw new BookNotFoundException("Book not found with ID: " + id);
    }
    bookRepository.deleteById(id);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Custom-Header", "Value");

    return ResponseEntity.noContent()
            .headers(headers)
            .build();
}

