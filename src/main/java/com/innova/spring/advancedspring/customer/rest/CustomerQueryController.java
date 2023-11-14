package com.innova.spring.advancedspring.customer.rest;

import com.innova.spring.advancedspring.customer.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/query")
public class CustomerQueryController {

    @GetMapping("/getall")
    public List<Customer> getAllCustomers(){
        return null;
    }

    @GetMapping("/find")
    public Customer find(@RequestParam("cid") Long customerId){
        return null;
    }


}
