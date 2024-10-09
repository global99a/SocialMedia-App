//package com.application.socialmedia.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(customizer->customizer.disable())// Disable CSRF for testing purposes
//                .authorizeRequests()
//                .requestMatchers("/api/users/**", "/api/articles/**", "/api/likes/**").permitAll() // Allow all requests to these endpoints
//                .anyRequest().authenticated(); // Require authentication for any other request
//
//        return http.build();
//    }
//}
//
