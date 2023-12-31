package com.innova.spring.advancedspring.customer.rest.mappings;

import com.innova.spring.advancedspring.customer.models.Customer;
import com.innova.spring.advancedspring.customer.models.Phone;
import com.innova.spring.advancedspring.customer.rest.models.CustomerDto;
import com.innova.spring.advancedspring.customer.rest.models.CustomerQueryDto;
import com.innova.spring.advancedspring.customer.rest.models.PhoneDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface ICustomerMapping {

    ICustomerMapping INSTANCE = Mappers.getMapper(ICustomerMapping.class);

    @Mapping(source = "firstName",target = "name")
    @Mapping(source = "lastName",target = "surname")
    @Mapping(source = "username",target = "customerCredentials.username")
    @Mapping(source = "password",target = "customerCredentials.password")
    @Mapping(source = "height",target = "customerDetails.height")
    @Mapping(source = "weight",target = "customerDetails.weight")
    @Mapping(source = "birthdate",target = "customerDetails.birthdate")
    Customer toCustomer(CustomerDto customer);

    @Mapping(target = "firstName",source = "name")
    @Mapping(target = "lastName",source = "surname")
    @Mapping(target = "username",source = "customerCredentials.username")
    @Mapping(target = "password",source = "customerCredentials.password")
    @Mapping(target = "height",source = "customerDetails.height")
    @Mapping(target = "weight",source = "customerDetails.weight")
    @Mapping(target = "birthdate",source = "customerDetails.birthdate")
    CustomerDto toCustomerDto(Customer customer);

    @Mapping(target = "firstName",source = "name")
    @Mapping(target = "lastName",source = "surname")
    @Mapping(target = "height",source = "customerDetails.height")
    @Mapping(target = "weight",source = "customerDetails.weight")
    @Mapping(target = "birthdate",source = "customerDetails.birthdate")
    CustomerQueryDto toCustomerQueryDto(Customer customer);

    List<CustomerQueryDto> toCustomerQueryDtos(List<Customer> customer);

    Phone toPhone(PhoneDto phone);

    PhoneDto toPhoneDto(Phone phone);

    Set<Phone> toPhones(Set<PhoneDto> phone);

    Set<PhoneDto> toPhoneDtos(Set<Phone> phone);

}
