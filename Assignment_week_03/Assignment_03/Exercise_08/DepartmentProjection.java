import org.springframework.beans.factory.annotation.Value;

public interface DepartmentProjection {
    
    @Value("#{target.name}")
    String getName();
}
