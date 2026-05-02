package com.kevinmorales.ventas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                    .requestMatchers("/login", "/register", "/css/**").permitAll()

                    .requestMatchers("/usuario", "/cliente", "/producto", "/venta", "/detalle").authenticated()

                    .requestMatchers("/usuario/**").hasRole("ADMIN")
                    .requestMatchers("/cliente/**").hasRole("ADMIN")
                    .requestMatchers("/producto/**").hasRole("ADMIN")
                    .requestMatchers("/venta/**").hasRole("ADMIN")
                    .requestMatchers("/detalle/**").hasRole("ADMIN")

                    .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true).permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}
