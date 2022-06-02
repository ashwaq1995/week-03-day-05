package com.demo.Ex5.W3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotEmpty
    private Integer id;

    private Integer age;

    private Integer balance;


    @OneToOne(cascade  = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

}
