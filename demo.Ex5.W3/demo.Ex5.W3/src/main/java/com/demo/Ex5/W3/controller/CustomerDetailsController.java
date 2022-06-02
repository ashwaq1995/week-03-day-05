package com.demo.Ex5.W3.controller;

import com.demo.Ex5.W3.DTO.Api;
import com.demo.Ex5.W3.model.CustomerDetails;
import com.demo.Ex5.W3.service.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customerDetail")
@RequiredArgsConstructor
public class CustomerDetailsController {
    private final CustomerDetailsService customerDetailsService;

    Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);


    //Get CustomersDetails
    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getCustomerDetails(){
        logger.info("New request coming to Customer details");
        List<CustomerDetails> customerDetails=customerDetailsService.getCustomerDetails();
        return ResponseEntity.status(HttpStatus.OK).body(customerDetails);
    }

    //Add new CustomerDetails
    @PostMapping("/add")
    public ResponseEntity<Api> addCustomerDetails(@RequestBody @Valid CustomerDetails customerDetails) {
        logger.info("add Customer details");
        customerDetailsService.addCustomerDetails(customerDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new Api("New CustomerDetails added !",201));
    }


}
