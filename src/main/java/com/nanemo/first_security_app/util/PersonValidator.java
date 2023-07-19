package com.nanemo.first_security_app.util;

import com.nanemo.first_security_app.entity.Person;
import com.nanemo.first_security_app.service.PersonDetailsService;
import com.nanemo.first_security_app.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PersonValidator implements Validator {

    private final PersonService personService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

    }
}
