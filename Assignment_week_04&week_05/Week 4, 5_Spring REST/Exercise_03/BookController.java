// GET a single book by ID
@GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    Optional<Book> book = bookRepository.findById(id);
    return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}
import org.springframework.web.bind.annotation.RequestParam;

// GET books with optional title and author filters
@GetMapping("/search")
public List<Book> searchBooks(
    @RequestParam(required = false) String title,
    @RequestParam(required = false) String author
) {
    if (title != null && author != null) {
        return bookRepository.findByTitleAndAuthor(title, author);
    } else if (title != null) {
        return bookRepository.findByTitle(title);
    } else if (author != null) {
        return bookRepository.findByAuthor(author);
    } else {
        return bookRepository.findAll();
    }
}

