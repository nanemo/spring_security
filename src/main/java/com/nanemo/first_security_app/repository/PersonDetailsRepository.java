package com.nanemo.first_security_app.repository;

import com.nanemo.first_security_app.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDetailsRepository extends JpaRepository<Person, Integer> {
}
