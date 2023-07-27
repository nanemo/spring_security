package com.nanemo.first_security_app.config;

import com.nanemo.first_security_app.service.PersonDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
//                .csrf().disable(). //here I turned off cross site referencing.
                authorizeRequests()
                .antMatchers("/auth/login", "/auth/registration", "/error").permitAll() // without these three line users can get
                .anyRequest().authenticated()                               // pages without authentication.
                .and()
                .formLogin().loginPage("/auth/login") // redirect to controller method login
                .loginProcessingUrl("/process_login") // send a login and a password to this url
                .defaultSuccessUrl("/hello", true) // we should write true because it redirects to /hello
                .failureUrl("/auth/login?error") // if we have the problems then redirect to this url with param
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/auth/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
