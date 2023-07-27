package com.nanemo.first_security_app.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Component
public class PersonDto {
    private Integer personId;

    @NotNull(message = "username can not be empty")
    private String username;

    @NotNull(message = "birthdate can not be empty")
//    @DateMin(value = "1991-04-04", message = "Date must not be lover than 4th April 1991")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotEmpty(message = "password can not be empty")
    @Size(min = 8, message = "password can not be lower than 8 characters")
    private String password;

}

