import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query method to find an employee by email
    Optional<Employee> findByEmail(String email);
    
    // Derived query method to find all employees by department name
    List<Employee> findByDepartmentName(String departmentName);
}
