package com.innova.spring.advancedspring.rest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UserCredential {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
