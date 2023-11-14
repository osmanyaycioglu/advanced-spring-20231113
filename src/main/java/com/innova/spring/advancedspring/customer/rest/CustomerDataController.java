package com.innova.spring.advancedspring.customer.rest;


import com.innova.spring.advancedspring.customer.models.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer/data")
public class CustomerDataController {


    @PostMapping("/change/data")
    public String update(@RequestBody Customer customer){
        return "OK";
    }



}
