import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    
    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the username or ID of the current user from your security context
        // For example, using Spring Security, you could return SecurityContextHolder.getContext().getAuthentication().getName();
        return Optional.of("system"); // This is a placeholder; replace with actual user retrieval logic
    }
}
