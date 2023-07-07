package com.nanemo.first_security_app.entity;

import com.nanemo.first_security_app.annotation.DateMin;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer personId;

    @NotEmpty(message = "username can not be empty")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "username can not be empty")
    @DateMin(value = "1991-04-04", message = "Date must not be lover than 4th April 1991")
    @Column(name = "password")
    private String password;
}

