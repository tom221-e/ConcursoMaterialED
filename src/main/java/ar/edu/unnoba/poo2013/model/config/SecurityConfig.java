package ar.edu.unnoba.poo2013.model.config;

import ar.edu.unnoba.poo2013.model.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserDetailsService userDetailsService;
    private SecurityService securityService;
    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, SecurityService securityService) {
        this.userDetailsService = userDetailsService;
        this.securityService = securityService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .userDetailsService(this.userDetailsService)
                .authorizeRequests((requests) -> requests
                        .requestMatchers("/webjars/**", "/resources/**", "/css/**").permitAll()
                        .requestMatchers("/admin/**").access("@securityService.isAdmin(authentication)")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form.permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}