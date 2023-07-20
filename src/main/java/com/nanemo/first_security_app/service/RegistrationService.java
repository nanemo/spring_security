package com.nanemo.first_security_app.service;

import com.nanemo.first_security_app.entity.Person;
import com.nanemo.first_security_app.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public Optional<Person> findByUsername(Person person) {
        return registrationRepository.findByUsername(person.getUsername());
    }

    public void registerPerson(Person person) {
        //TODO check the Person type param for empty.
        registrationRepository.save(person);
    }

}