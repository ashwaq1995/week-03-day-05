package com.demo.Ex5.W3.controller;


import com.demo.Ex5.W3.DTO.Api;
import com.demo.Ex5.W3.DTO.BankDTO;
import com.demo.Ex5.W3.model.Bank;
import com.demo.Ex5.W3.model.Customer;
import com.demo.Ex5.W3.repository.BankRepository;
import com.demo.Ex5.W3.repository.CustomerRepository;
import com.demo.Ex5.W3.service.BankService;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/bank")
public class BankController {

    private final BankService bankService;

    private final CustomerRepository customerRepository;
    private final BankRepository bankRepository;

    Logger logger = LoggerFactory.getLogger(BankController.class);

    //Get all banks
    @GetMapping()
    public ResponseEntity<List<Bank>> getBank() {
        logger.info("New request coming to getBank");
        List<Bank> banks = bankService.getBank();
        return ResponseEntity.status(HttpStatus.OK).body(banks);
    }


    //Add
//    @PostMapping("/add")
//    public ResponseEntity<Api> addBank(@RequestBody @Valid Bank bank) {
//        logger.info("add bank");
//        bankService.addBank(bank);
//        return ResponseEntity.status(HttpStatus.CREATED).body(
//                new Api("New Bank added !",201));
//    }

    //Add new banks
    @PostMapping
    public ResponseEntity addBank(@RequestBody @Valid  BankDTO bankDTO) {
        Customer customer = customerRepository.findById(bankDTO.getCustomerId()).get();
        Bank bank = new Bank(null,bankDTO.getName(),customer);
        customer.getBanks().add(bank);
        bankRepository.save(bank);
        return ResponseEntity.status(HttpStatus.OK).body(bankRepository.findAll());
    }

}