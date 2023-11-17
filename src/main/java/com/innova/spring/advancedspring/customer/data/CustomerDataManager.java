package com.innova.spring.advancedspring.customer.data;

import com.innova.spring.advancedspring.customer.data.dao.ICustomerDao;
import com.innova.spring.advancedspring.customer.models.Customer;
import com.innova.spring.advancedspring.customer.models.ECustomerStatus;
import com.innova.spring.advancedspring.customer.models.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerDataManager {
    private final ICustomerDao customerDao;

    public void insert(Customer customerParam) {
        Set<Phone> phonesLoc = customerParam.getPhones();
        if (phonesLoc != null){
            for (Phone phoneLoc : phonesLoc) {
                phoneLoc.setCustomer(customerParam);
            }
        }
        customerParam.setCustomerUid(UUID.randomUUID()
                                         .toString());
        customerDao.save(customerParam);
    }

    public void updateStatus(final ECustomerStatus eCustomerStatusParam,
                             final String cuidParam) {
        customerDao.updateStatus(eCustomerStatusParam,
                                 cuidParam);
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public Customer finOne(final String customerIdParam) {
        return customerDao.findByCustomerUid(customerIdParam);
    }

    public List<Customer> findBySurname(final String surnameParam) {
        return customerDao.findBySurname(surnameParam);
    }
}
