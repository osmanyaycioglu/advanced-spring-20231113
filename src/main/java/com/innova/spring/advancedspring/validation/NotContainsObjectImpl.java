package com.innova.spring.advancedspring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NotContainsObjectImpl implements ConstraintValidator<NotContains, Object> {

    private NotContains notContains;

    @Override
    public void initialize(final NotContains constraintAnnotation) {
        notContains = constraintAnnotation;
    }

    @Override
    public boolean isValid(final Object value,
                           final ConstraintValidatorContext context) {
        Class<?>     classLoc          = value.getClass();
        Field[]      declaredFieldsLoc = classLoc.getDeclaredFields();
        String[]     badWordsLoc          = notContains.value();
        List<String> errorList         = new ArrayList<>();
        for (Field declaredFieldLoc : declaredFieldsLoc) {
            if (declaredFieldLoc.getType() == String.class) {
                try {
                    declaredFieldLoc.setAccessible(true);
                    String oLoc = (String) declaredFieldLoc.get(value);
                    for (String badWordLoc : badWordsLoc) {
                        if (oLoc.contains(badWordLoc)) {
                            errorList.add("Field : " + declaredFieldLoc.getName() + " contains : " + badWordLoc);
                        }
                    }
                } catch (Exception eParam) {
                    eParam.printStackTrace();
                }
            }
        }
        if (errorList.isEmpty()) {
            return true;
        } else {
            String collectLoc = errorList.stream()
                                         .collect(Collectors.joining(", "));
            context.disableDefaultConstraintViolation();
            ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilderLoc = context.buildConstraintViolationWithTemplate(collectLoc);
            constraintViolationBuilderLoc.addConstraintViolation();
            return false;
        }

    }
}
