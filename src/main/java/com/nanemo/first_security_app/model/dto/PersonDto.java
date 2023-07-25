package com.nanemo.first_security_app.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanemo.first_security_app.annotation.DateMin;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PersonDto {
    private Integer personId;

    @NotBlank(message = "username can not be empty")
    private String username;

    @NotBlank(message = "username can not be empty")
//    @DateMin(value = "1991-04-04", message = "Date must not be lover than 4th April 1991")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;

    @Size(min = 8, message = "password can not be lower than 8 characters")
    private String password;

//    @NotBlank(message = "username can not be empty")
//    @Size(min = 8, message = "password can not be lower than 8 characters")
//    private String confirmPassword;

}

