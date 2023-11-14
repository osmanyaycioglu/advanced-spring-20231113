package com.innova.spring.advancedspring.customer.rest;

import com.innova.spring.advancedspring.customer.models.Customer;
import com.innova.spring.advancedspring.customer.rest.models.CustomerDto;
import com.innova.spring.advancedspring.customer.rest.models.CustomerQueryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/query")
public class CustomerQueryController {

    @GetMapping("/getall")
    public List<CustomerQueryDto> getAllCustomers(){
        return null;
    }

    @GetMapping("/find")
    public CustomerQueryDto find(@RequestParam("cid") Long customerId){
        return null;
    }


}
