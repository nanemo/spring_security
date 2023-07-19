package com.nanemo.first_security_app.service;

import com.nanemo.first_security_app.entity.Person;
import com.nanemo.first_security_app.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PeopleRepository peopleRepository;

    //TODO create and connect this method with PersonValidator class.
    public Optional<Person> findUserBy

}
