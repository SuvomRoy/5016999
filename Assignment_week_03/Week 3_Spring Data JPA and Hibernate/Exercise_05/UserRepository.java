// File: UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findUsersByName(@Param("name") String name);

    @Query("DELETE FROM User u WHERE u.email = :email")
    void deleteUserByEmail(@Param("email") String email);

    @Query("SELECT COUNT(u) FROM User u WHERE u.name = :name")
    long countUsersByName(@Param("name") String name);
}
