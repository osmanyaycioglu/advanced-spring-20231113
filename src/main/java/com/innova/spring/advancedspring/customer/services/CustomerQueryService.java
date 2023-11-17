package com.innova.spring.advancedspring.customer.services;

import com.innova.spring.advancedspring.customer.data.CustomerDataManager;
import com.innova.spring.advancedspring.customer.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerQueryService {
    private final CustomerDataManager customerDataManager;

    public List<Customer> queryAllCustomer() {
        return customerDataManager.findAll();
    }

    public Customer queryCustomer(final String customerIdParam) {
        return customerDataManager.finOne(customerIdParam);
    }

    public List<Customer> queryCustomerBySurname(final String surnameParam) {
        return customerDataManager.findBySurname(surnameParam);
    }
}
