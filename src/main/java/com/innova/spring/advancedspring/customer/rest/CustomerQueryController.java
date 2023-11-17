package com.innova.spring.advancedspring.customer.rest;

import com.innova.spring.advancedspring.customer.models.Customer;
import com.innova.spring.advancedspring.customer.rest.mappings.ICustomerMapping;
import com.innova.spring.advancedspring.customer.rest.models.CustomerDto;
import com.innova.spring.advancedspring.customer.rest.models.CustomerQueryDto;
import com.innova.spring.advancedspring.customer.services.CustomerQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/query")
@RequiredArgsConstructor
public class CustomerQueryController {
    private final CustomerQueryService cqs;

    @GetMapping("/get/all")
    public List<CustomerQueryDto> getAllCustomers() {
        return ICustomerMapping.INSTANCE.toCustomerQueryDtos(cqs.queryAllCustomer());
    }

    @GetMapping("/get/one")
    public CustomerQueryDto find(@RequestParam("cid") String customerId) {
        return ICustomerMapping.INSTANCE.toCustomerQueryDto(cqs.queryCustomer(customerId));
    }

    @GetMapping("/get/by/surname")
    public List<CustomerQueryDto> getCustomersBySurname(@RequestParam String surname) {
        return ICustomerMapping.INSTANCE.toCustomerQueryDtos(cqs.queryCustomerBySurname(surname));
    }



}
