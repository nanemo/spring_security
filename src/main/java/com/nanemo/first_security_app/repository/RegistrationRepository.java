package com.nanemo.first_security_app.repository;

import com.nanemo.first_security_app.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);
}
