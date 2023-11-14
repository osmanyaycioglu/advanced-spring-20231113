package com.innova.spring.advancedspring.customer.rest.models;

import com.innova.spring.advancedspring.validation.NotContains;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CustomerQueryDto {
    private String    firstName;
    private String    lastName;
    private LocalDate birthdate;
    private Integer   weight;
    private Integer   height;
}
