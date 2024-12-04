package com.example.webstore.controller;

import com.example.webstore.repository.CustomerRepository;
import com.example.webstore.entity.Customer;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("/Customer/{id}")
    public Customer GetCustomerById(@PathVariable("id") long id){
        return customerRepository.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/Customer/Secure/{id}")
    public Customer GetCustomerByIdSecure(@PathVariable("id") long id){
        return customerRepository.findById(id);
    }

}
