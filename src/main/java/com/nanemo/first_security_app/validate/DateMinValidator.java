package com.nanemo.first_security_app.validate;

import com.nanemo.first_security_app.annotation.DateMin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateMinValidator implements ConstraintValidator<DateMin, LocalDate> {

    private LocalDate minValue;

    @Override
    public void initialize(DateMin constraintAnnotation) {
        minValue = LocalDate.parse(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return value.isAfter(minValue) || value.isEqual(minValue);
    }
}
