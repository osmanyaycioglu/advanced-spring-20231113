package com.innova.spring.advancedspring.customer.rest;

import com.innova.spring.advancedspring.customer.models.Customer;
import com.innova.spring.advancedspring.customer.rest.models.CustomerDto;
import com.innova.spring.advancedspring.error.ErrorObj;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerProvisionController {

    @PostMapping("/add")
    public String add(@Valid @RequestBody CustomerDto customer) {
        return "OK";
    }

    @PostMapping("/suspend")
    public String suspend(@RequestBody Customer customer) {
        return "OK";
    }


}
