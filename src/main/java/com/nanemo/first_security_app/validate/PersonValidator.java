package com.nanemo.first_security_app.validate;

import com.nanemo.first_security_app.model.dto.PersonDto;
import com.nanemo.first_security_app.model.entity.Person;
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
        PersonDto personDto = (PersonDto) o;

        checkUsernameExist(personDto, errors);
    }

    private void checkUsernameExist(PersonDto personDto, Errors errors) {
        registrationService.findByUsername(personDto).ifPresent(error ->
                errors.rejectValue("field", "", "This username is exist!"));
    }

}