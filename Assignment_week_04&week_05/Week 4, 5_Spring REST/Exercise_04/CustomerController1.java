import org.springframework.web.bind.annotation.RequestParam;

// POST endpoint to create a new customer with form data
@PostMapping("/register/form")
public ResponseEntity<Customer> registerCustomerForm(
    @RequestParam String name,
    @RequestParam String email,
    @RequestParam String password
) {
    Customer customer = new Customer();
    customer.setName(name);
    customer.setEmail(email);
    customer.setPassword(password);
    
    Customer savedCustomer = customerRepository.save(customer);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
}
