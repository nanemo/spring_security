package com.nanemo.first_security_app.service;

import com.nanemo.first_security_app.model.dto.PersonDto;
import com.nanemo.first_security_app.model.mapper.PersonMapper;
import com.nanemo.first_security_app.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final PersonMapper personMapper;

    public Optional<PersonDto> findByUsername(PersonDto personDto) {
        return registrationRepository.findByUsername(personMapper.toEntity(personDto).getUsername())
                .stream().map(personMapper::toDto).findFirst();
    }

    @Transactional
    public void registerPerson(PersonDto personDto) {
        registrationRepository.save(personMapper.toEntity(personDto));
    }

}