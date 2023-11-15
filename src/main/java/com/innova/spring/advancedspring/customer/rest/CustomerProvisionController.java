package com.innova.spring.advancedspring.customer.rest;

import com.innova.spring.advancedspring.customer.models.Customer;
import com.innova.spring.advancedspring.customer.rest.models.CustomerDto;
import com.innova.spring.advancedspring.customer.services.CustomerProvisionService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.innova.spring.advancedspring.customer.rest.mappings.ICustomerMapping;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer/provision")
@RequiredArgsConstructor
public class CustomerProvisionController {

    private final CustomerProvisionService cs;

    @PostMapping("/add")
    public String add(@Valid @RequestBody CustomerDto customer) {
        cs.addCustomer(ICustomerMapping.INSTANCE.toCustomer(customer));
        return "OK";
    }

    @PostMapping("/suspend")
    public String suspend(@RequestBody Customer customer) {
        return "OK";
    }


}
