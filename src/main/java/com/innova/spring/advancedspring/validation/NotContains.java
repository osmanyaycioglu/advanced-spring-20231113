package com.innova.spring.advancedspring.validation;

import com.innova.spring.advancedspring.customer.rest.models.CustomerDto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,
         ElementType.METHOD,
         ElementType.TYPE
})
@Documented
@Constraint(validatedBy = {NotContainsImpl.class,
                           NotContainsObjectImpl.class
})
public @interface NotContains {
    String[] value();

    String message() default "{javax.validation.constraints.NotContains.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
