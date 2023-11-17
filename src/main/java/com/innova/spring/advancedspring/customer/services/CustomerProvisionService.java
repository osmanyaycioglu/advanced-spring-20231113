package com.innova.spring.advancedspring.customer.services;

import com.innova.spring.advancedspring.customer.data.CustomerDataManager;
import com.innova.spring.advancedspring.customer.models.Customer;
import com.innova.spring.advancedspring.customer.models.ECustomerStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerProvisionService {
    private final CustomerDataManager customerDataManager;

    public String addCustomer(Customer customerParam){
        customerDataManager.insert(customerParam);
        return customerParam.getCustomerUid();
    }

    public void suspend(final String cuidParam) {
        customerDataManager.updateStatus(ECustomerStatus.SUSPENDED,cuidParam);
    }
}
