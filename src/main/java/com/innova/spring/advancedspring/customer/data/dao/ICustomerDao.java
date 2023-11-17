package com.innova.spring.advancedspring.customer.data.dao;

import com.innova.spring.advancedspring.customer.models.Customer;
import com.innova.spring.advancedspring.customer.models.ECustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ICustomerDao extends JpaRepository<Customer, Long> {

    @Modifying
    @Transactional
    @Query("update Customer c set c.customerStatus=?1 where c.customerUid=?2")
    void updateStatus(ECustomerStatus customerStatusParam,
                      String cuid);

    @Modifying
    @Transactional
    @Query("update Customer c set c.customerStatus=:cstatus where c.customerUid=:cuid")
    void updateStatus2(@Param("cstatus") ECustomerStatus customerStatusParam,
                       @Param("cuid") String cuid);


    Customer findByCustomerUid(String customerUid);

    List<Customer> findBySurname(String surname);
}
