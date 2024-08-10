import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
    
    @Value("#{target.name}")
    String getName();
    
    @Value("#{target.department}")
    String getDepartment();
}
