package com.innova.spring.advancedspring.customer.rest;

import com.innova.spring.advancedspring.customer.models.Customer;
import com.innova.spring.advancedspring.customer.rest.models.CustomerDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerProvisionController {

    @PostMapping("/add")
    public String add(@Valid @RequestBody CustomerDto customer){
        return "OK";
    }

    @PostMapping("/suspend")
    public String suspend(@RequestBody Customer customer){
        return "OK";
    }

}
