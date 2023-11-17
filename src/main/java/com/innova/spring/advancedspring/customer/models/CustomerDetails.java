package com.innova.spring.advancedspring.customer.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Embeddable
public class CustomerDetails {
    private LocalDate birthdate;
    private Integer   weight;
    private Integer   height;

}
