package com.demo.Ex5.W3.service;

import com.demo.Ex5.W3.model.CustomerDetails;
import com.demo.Ex5.W3.repository.CustomerDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {
    private final CustomerDetailsRepository customerDetailsRepository;

    public List<CustomerDetails> getCustomerDetails() {
        return customerDetailsRepository.findAll();
    }


    public void addCustomerDetails(CustomerDetails customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }
}
