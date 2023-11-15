package com.innova.spring.advancedspring.customer.services;

import com.innova.spring.advancedspring.customer.models.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerProvisionService {

    public String addCustomer(Customer customerParam){

        return "OK";
    }

}
