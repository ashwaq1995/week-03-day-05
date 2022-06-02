package com.demo.Ex5.W3.service;


import com.demo.Ex5.W3.exceptions.InvalidIdException;
import com.demo.Ex5.W3.model.Bank;
import com.demo.Ex5.W3.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;


    public List<Bank> getBank() {
        return bankRepository.findAll();
    }


//    public void checkBankIsValid(Integer id) {
//        Bank bank = bankRepository.findById(id)
//                .orElseThrow(
//                        () -> new InvalidIdException("Invalid id"));
//    }


    public void addBank(Bank bank)  {
        bankRepository.save(bank);
    }

}
