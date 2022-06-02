package com.demo.Ex5.W3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class CustomerDetailsDTO {
    private Integer id;
    private Integer age;
    private Integer balance;
}
