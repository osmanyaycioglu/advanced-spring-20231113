package com.innova.spring.advancedspring.customer.rest;

import com.innova.spring.advancedspring.customer.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// doğru bir yaklaşım değil
@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @PostMapping("/insert")
    public String insert(@RequestBody Customer customer){
        return "OK";

    }

    @PostMapping("/update")
    public String update(@RequestBody Customer customer){
        return "OK";

    }

    @GetMapping("/getall")
    public List<Customer> getAllCustomers(){
        return null;
    }

    @GetMapping("/find")
    public Customer find(@RequestParam("cid") Long customerId){
        return null;
    }


}
