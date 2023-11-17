package com.innova.spring.advancedspring.customer.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class CustomerCredentials {
    @Id
    @GeneratedValue
    private Long ccId;
    private String    username;
    private String    password;

}
