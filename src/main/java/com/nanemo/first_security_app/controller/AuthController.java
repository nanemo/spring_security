package com.nanemo.first_security_app.controller;

import com.nanemo.first_security_app.model.dto.PersonDto;
import com.nanemo.first_security_app.service.RegistrationService;
import com.nanemo.first_security_app.validate.PersonValidator;
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

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") PersonDto personDto,
                                   ModelMap modelMap) {
        modelMap.addAttribute("person", personDto);
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registerPerson(@ModelAttribute("person") @Valid PersonDto personDto,
                                 BindingResult bindingResult) {
        personValidator.validate(personDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "auth/registration";
        }

        registrationService.registerPerson(personDto);
        return "redirect:/hello/show_user_info";
    }

}
