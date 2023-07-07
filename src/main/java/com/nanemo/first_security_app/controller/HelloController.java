package com.nanemo.first_security_app.controller;

import com.nanemo.first_security_app.service.PersonDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello_controller")
public class HelloController {

    private final PersonDetailsService personDetailsService;

    public HelloController(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @GetMapping
    public String hello(){
        return personDetailsService.getPersonDetails();
    }

}
