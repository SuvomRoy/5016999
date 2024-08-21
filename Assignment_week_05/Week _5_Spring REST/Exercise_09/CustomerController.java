package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.exception.CustomerNotFoundException;
import com.example.bookstoreapi.mapper.CustomerMapper;
import com.example.bookstoreapi.model.Customer;
import com.example.bookstoreapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @PostMapping(value = "/register",
                 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CustomerDTO> registerCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toDTO(savedCustomer));
    }

    @GetMapping(value = "/{id}",
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + id));
        return ResponseEntity.ok(customerMapper.toDTO(customer));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerRepository.findAll().stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(customers);
    }

    @PutMapping(value = "/{id}",
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDTO customerDTO) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
        Customer customer = customerMapper.toEntity(customerDTO);
        customer.setId(id);
        Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(customerMapper.toDTO(updatedCustomer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
        customerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
