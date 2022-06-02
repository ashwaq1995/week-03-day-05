package com.demo.Ex5.W3.repository;

import com.demo.Ex5.W3.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Integer>{
}
