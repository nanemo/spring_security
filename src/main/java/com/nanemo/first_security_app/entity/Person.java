package com.nanemo.first_security_app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanemo.first_security_app.annotation.DateMin;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer personId;

    @NotBlank(message = "username can not be empty")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "username can not be empty")
    @DateMin(value = "1991-04-04", message = "Date must not be lover than 4th April 1991")
    @JsonFormat(pattern = "yyyy-DD-mm")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Size(min = 8, message = "password can not be lower than 8 characters")
    @Column(name = "password")
    private String password;

}

