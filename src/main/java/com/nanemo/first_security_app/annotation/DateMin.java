package com.nanemo.first_security_app.annotation;

import com.nanemo.first_security_app.validate.DateMinValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Past;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Past
@Constraint(validatedBy = DateMinValidator.class)
public @interface DateMin {

    String message() default "Date must be after the specified minimum date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();
}
