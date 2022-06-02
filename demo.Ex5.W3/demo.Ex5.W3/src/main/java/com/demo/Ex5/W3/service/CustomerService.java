package com.demo.Ex5.W3.service;

import com.demo.Ex5.W3.exceptions.InvalidIdException;
import com.demo.Ex5.W3.model.Customer;
import com.demo.Ex5.W3.model.CustomerDetails;
import com.demo.Ex5.W3.repository.CustomerDetailsRepository;
import com.demo.Ex5.W3.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDetailsRepository customerDetailsRepository;


    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer)  {
        customerRepository.save(customer);
    }

    //return bad request if customer is invalid
    public void deposit(Integer id, Integer amount) {
        CustomerDetails customerDetails = customerDetailsRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));
        customerDetails.setBalance(customerDetails.getBalance() + amount);
        customerDetailsRepository.save(customerDetails);
    }

    //return bad request if customer is invalid / customers doesn't have funds
    public void withdraw(Integer id, Integer amount) {
        CustomerDetails customerDetails = customerDetailsRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));
        if (customerDetails.getBalance() < amount)
            throw new RuntimeException("Customer does not has enough funds!");
        customerDetails.setBalance(customerDetails.getBalance() - amount);
        customerDetailsRepository.save(customerDetails);
    }



}
