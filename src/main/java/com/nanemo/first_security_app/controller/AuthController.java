package com.nanemo.first_security_app.controller;

import com.nanemo.first_security_app.entity.Person;
import com.nanemo.first_security_app.service.PersonDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final PersonDetailsService personDetailsService;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/register_page")
    public String registrationPage(@ModelAttribute("person") Person person,
                                   ModelMap modelMap,
                                   BindingResult bindingResult) {
        modelMap.addAttribute("person", person);
        return "auth/registration";
    }

    @PostMapping("/register")
    public String registerPerson(@ModelAttribute @Valid Person person) {
        personDetailsService.registerPerson(person);
        return "auth/login";
    }

}
