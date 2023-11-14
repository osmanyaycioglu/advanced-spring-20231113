package com.innova.spring.advancedspring.rest;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GreetingsObject {
    private String       name;
    private String       surname;
    private Integer      age;
    private List<String> names;
}
