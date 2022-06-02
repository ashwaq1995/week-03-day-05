package com.demo.Ex5.W3.controller;

import com.demo.Ex5.W3.DTO.Api;
import com.demo.Ex5.W3.DTO.CustomerDetailsDTO;
import com.demo.Ex5.W3.model.Customer;
import com.demo.Ex5.W3.model.CustomerDetails;
import com.demo.Ex5.W3.repository.CustomerDetailsRepository;
import com.demo.Ex5.W3.repository.CustomerRepository;
import com.demo.Ex5.W3.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerDetailsRepository customerDetailsRepository;
    private final CustomerService customerService;

    //Add logging
    Logger logger = LoggerFactory.getLogger(CustomerController.class);


    //Get all customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        logger.info("get customer");
        List<Customer> customers = customerService.getCustomer();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }


    //Add new customer
    @PutMapping("/add")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        logger.info("add customer");
        customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Customer added !",201));
    }

    @PutMapping("details")
    public ResponseEntity addCustomerDetails(@RequestBody CustomerDetailsDTO cd){
        Customer customer = customerRepository.findById(cd.getId()).get();

        CustomerDetails customerDetails=new CustomerDetails(
                null,cd.getAge(),cd.getBalance(),customer);
        customer.setCustomerDetails(customerDetails);

        customerDetailsRepository.save(customerDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Customer added !",201));
    }



    //Create endpoint that deposits money
    @PutMapping("/deposit")
    public ResponseEntity deposit(@PathVariable Integer id,@PathVariable Integer amount) {
        customerService.deposit(id, amount);
        return ResponseEntity.status(200).body("Deposit completed");
    }

    //Create endpoint that withdraws money
    @PutMapping("/withdraw")
    public ResponseEntity withdraw(@PathVariable Integer id,@PathVariable Integer amount) {
        customerService.withdraw(id, amount);
        return ResponseEntity.status(200).body("Withdraw completed");
    }


}