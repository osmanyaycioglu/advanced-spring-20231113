package com.innova.spring.advancedspring.customer.rest.models;

import com.innova.spring.advancedspring.customer.models.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class PhoneDto {
    private String   phoneName;
    private String phoneNumber;

}
