package com.innova.spring.advancedspring.customer.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CustomerDetails {
    private LocalDate birthdate;
    private Integer   weight;
    private Integer   height;

}
