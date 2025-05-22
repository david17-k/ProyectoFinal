package com.proyectoestructura.estructuraDatos.Controller;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

@Controller
public class SeguridadConfig {


        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth
                            .anyRequest().permitAll() // Permitir todas las solicitudes
                    )
                    .csrf(csrf -> csrf.disable()) // Nueva forma de desactivar CSRF
                    .formLogin(form -> form.disable()); // Desactivar formulario de login por defecto

            return http.build();
        }

}
