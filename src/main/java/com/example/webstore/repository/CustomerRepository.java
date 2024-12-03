package com.example.webstore.repository;

import com.example.webstore.entity.Customer;

import org.springframework.data.repository.Repository;

public interface CustomerRepository extends Repository<Customer, Long>{

    Customer findById(Long id);

    Customer save(Customer customer);
}
