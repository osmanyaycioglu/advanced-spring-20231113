package com.innova.spring.advancedspring.customer.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Customer {
    private Long                customerId;
    private String              customerUid;
    private String              name;
    private String              surname;
    private CustomerCredentials customerCredentials;
    private CustomerDetails     customerDetails;
    private LocalDateTime       creationDate;
    private LocalDateTime       updateDate;
    private ECustomerStatus     customerStatus;

}
