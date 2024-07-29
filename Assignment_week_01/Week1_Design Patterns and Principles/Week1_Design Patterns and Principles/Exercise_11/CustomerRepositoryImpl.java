package Exercise_11;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // Dummy data for the sake of example
        return new Customer(id, "John Doe");
    }
}

