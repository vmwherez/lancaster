package com.example.springboot_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/items/**").permitAll()
                    .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                    .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.ignoringRequestMatchers("/items/**"))
            // Configure Custom Login Page
            .formLogin(form -> form
                // Specifies the path to your custom login page (GET request)
                .loginPage("/login")
                // Specifies the URL where the login form will POST the credentials
                // Spring Security handles the actual form processing at this endpoint
                .loginProcessingUrl("/perform_login")
                // URL to redirect to after successful login
                .defaultSuccessUrl("/home", true)
                // URL to redirect to after failed login
                .failureUrl("/login?error")
            )
            
            // Configure Custom Logout
            .logout(logout -> logout
                // Specifies the path for the logout POST request
                // You will link your logout button/form to this URL
                .logoutUrl("/perform_logout")
                // URL to redirect to after successful logout
                .logoutSuccessUrl("/login?logout")
                // Optional: invalidate the HTTP session
                .invalidateHttpSession(true)
                // Optional: remove all authentication cookies
                .deleteCookies("JSESSIONID")
            );

        return http.build();
    }
}
