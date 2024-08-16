import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Custom query methods for filtering
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByTitleAndAuthor(String title, String author);
}
