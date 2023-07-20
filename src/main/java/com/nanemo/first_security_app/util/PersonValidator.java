package com.nanemo.first_security_app.util;

import com.nanemo.first_security_app.entity.Person;
import com.nanemo.first_security_app.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PersonValidator implements Validator {

    private final RegistrationService registrationService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (registrationService.findByUsername(person).isPresent()) {
            errors.rejectValue("field", "", "This username is exist!");
        }

    }

}
