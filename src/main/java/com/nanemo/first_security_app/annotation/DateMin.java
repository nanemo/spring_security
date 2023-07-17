package com.nanemo.first_security_app.annotation;

import com.nanemo.first_security_app.validate.DateMinValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Past;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = DateMinValidator.class)
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Past
public @interface DateMin {

    String message() default "Date must be after the specified minimum date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();
}
