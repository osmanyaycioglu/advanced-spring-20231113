package com.innova.spring.advancedspring.error;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder(setterPrefix = "with")
@Jacksonized
@Getter
public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String message;
    private Integer errorCode;
}
