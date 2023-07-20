package com.nanemo.first_security_app.controller;

import com.nanemo.first_security_app.entity.Person;
import com.nanemo.first_security_app.service.RegistrationService;
import com.nanemo.first_security_app.util.PersonValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final PersonValidator personValidator;

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
    public String registerPerson(@ModelAttribute @Valid Person person, BindingResult bindingResult) {
        registrationService.findByUsername(person);
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "auth/login";
        }

        registrationService.registerPerson(person);

        return "redirect:/hello/show_user_info";
    }

}
