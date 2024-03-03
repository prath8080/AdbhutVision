package com.app.service;

import com.app.pojo.Customer;
import com.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Optional<Customer> findCustomerByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    public List<Customer> findCustomersByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Customer> findCustomersByNameIgnoreCase(String name) {
        return customerRepository.findCustomersByNameIgnoreCaseWithEfficientQuery(name);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerByEmail(String email) {
        customerRepository.deleteByEmail(email);
    }

    // Add more methods as needed

}
