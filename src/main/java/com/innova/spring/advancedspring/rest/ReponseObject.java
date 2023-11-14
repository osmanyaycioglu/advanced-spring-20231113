package com.innova.spring.advancedspring.rest;

import lombok.Data;

@Data
public class ReponseObject<T> {
    private String errorDesc;
    private Integer errorCause;
    private Boolean errorOccured;
    private T value;
}
