package com.nanemo.first_security_app.model.mapper;

import com.nanemo.first_security_app.model.dto.PersonDto;
import com.nanemo.first_security_app.model.entity.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {

    PersonDto toDto(Person person);

    Person toEntity(PersonDto personDto);

}
