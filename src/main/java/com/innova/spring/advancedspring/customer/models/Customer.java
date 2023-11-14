package com.innova.spring.advancedspring.customer.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Customer {
    private String    firstName;
    private String    lastName;
    private String    username;
    private String    password;
    private LocalDate birthdate;
    private Integer   weight;
    private Integer   height;
}
