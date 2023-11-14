package com.innova.spring.advancedspring.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj errorHandler(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withMessage(exp.getMessage())
                       .withErrorCode(1034)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj errorHandler(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withMessage("Validation error")
                       .withErrorCode(1043)
                       .withSubErrors(exp.getAllErrors()
                                         .stream()
                                         .map(spe -> ErrorObj.builder()
                                                             .withMessage("" + spe)
                                                             .withErrorCode(1044)
                                                             .build())
                                         .collect(Collectors.toList()))
                       .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj errorHandler(ConstraintViolationException exp) {
        return ErrorObj.builder()
                       .withMessage("Validation error")
                       .withErrorCode(1043)
                       .withSubErrors(exp.getConstraintViolations()
                                         .stream()
                                         .map(spe -> ErrorObj.builder()
                                                             .withMessage("" + spe)
                                                             .withErrorCode(1044)
                                                             .build())
                                         .collect(Collectors.toList()))
                       .build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> errorHandler(Exception exp) {
        if (exp instanceof NullPointerException){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body(ErrorObj.builder()
                                               .withMessage(exp.getMessage())
                                               .withErrorCode(4001)
                                               .build());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ErrorObj.builder()
                                           .withMessage(exp.getMessage())
                                           .withErrorCode(5000)
                                           .build());
    }


}
