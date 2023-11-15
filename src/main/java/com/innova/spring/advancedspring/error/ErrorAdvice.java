package com.innova.spring.advancedspring.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ErrorAdvice.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj errorHandler(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withMessage(exp.getMessage())
                       .withErrorCode(1034)
                       .build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorObj errorHandler(AccessDeniedException exp) {
        return ErrorObj.builder()
                       .withMessage("Buraya giriş hakkınız yok")
                       .withErrorCode(3333)
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
        logger.error("Exp : " + exp.getMessage(),
                     exp);
        if (exp instanceof NullPointerException) {
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
