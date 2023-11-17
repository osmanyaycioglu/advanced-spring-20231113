package com.innova.spring.advancedspring.customer.rest.models;

import com.innova.spring.advancedspring.user.EUserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetails {
    private String    uname;
    private EUserRole rname;
}

