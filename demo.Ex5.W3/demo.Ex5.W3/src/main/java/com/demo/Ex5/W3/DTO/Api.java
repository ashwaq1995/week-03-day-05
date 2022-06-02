package com.demo.Ex5.W3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Api {
    private String message;
    private Integer status;
}