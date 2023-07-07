package com.nanemo.first_security_app.service;

import com.nanemo.first_security_app.repository.PersonDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService {

    private final PersonDetailsRepository personDetailsRepository;

    @Autowired
    public PersonDetailsService(PersonDetailsRepository personDetailsRepository) {
        this.personDetailsRepository = personDetailsRepository;
    }


    public String getPersonDetails() {
        return null;
    }
}
