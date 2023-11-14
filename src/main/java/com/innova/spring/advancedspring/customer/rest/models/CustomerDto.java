package com.innova.spring.advancedspring.customer.rest.models;

import com.innova.spring.advancedspring.validation.NotContains;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@NotContains({"abc","xyz","123","456"})
public class CustomerDto {
    @NotEmpty
    @Size(min = 2, max = 15)
    private String    firstName;
    @NotEmpty
    @Size(min = 3, max = 25)
    private String    lastName;
    @NotEmpty
    @Size(min = 6, max = 12)
    private String    username;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password en az bir rakam ve en az bir karakter barındırmalı")
    private String    password;
    @NotNull
    private LocalDate birthdate;
    @NotNull
    @Max(500)
    @Min(10)
    private Integer   weight;
    @NotNull
    @Max(300)
    @Min(50)
    private Integer   height;
}
