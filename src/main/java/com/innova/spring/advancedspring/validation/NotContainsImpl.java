package com.innova.spring.advancedspring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class NotContainsImpl implements ConstraintValidator<NotContains, String> {

    private NotContains notContains;

    @Override
    public void initialize(final NotContains constraintAnnotation) {
        notContains = constraintAnnotation;
    }

    @Override
    public boolean isValid(final String value,
                           final ConstraintValidatorContext context) {
//        String[] valueLoc = notContains.value();
//        for (String stringLoc : valueLoc) {
//            if (value.contains(stringLoc)){
//                return false;
//            }
//        }
//        return true;

        return Arrays.stream(notContains.value())
                     .noneMatch(value::contains);
    }
}
