package Exercise_11;

public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        Customer customer = customerService.findCustomerById("1");
        System.out.println(customer);
    }
}

