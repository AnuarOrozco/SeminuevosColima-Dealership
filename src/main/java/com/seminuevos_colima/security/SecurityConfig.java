package com.seminuevos_colima.security;

import com.seminuevos_colima.service.impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF (solo si estás trabajando con APIs REST)
                .authorizeHttpRequests(auth -> auth
                        // Permitir acceso sin autenticación a las rutas de registro y login
                        .requestMatchers("/api/auth/register", "/api/auth/login", "/req/signup", "/css/**", "/js/**").permitAll()
                        // Asegurarse de que cualquier otra ruta requiere autenticación
                        .anyRequest().authenticated()
                )
                // Configurar el login de forma estándar (si es necesario)
                .formLogin(form -> form
                        .loginPage("/login")  // Página de login
                        .loginProcessingUrl("/login") // URL de procesamiento del login
                        .defaultSuccessUrl("/home", true) // Redirigir al home tras un login exitoso
                        .failureUrl("/login?error=true") // Redirigir al login en caso de error
                )
                // Configuración de logout
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL para cerrar sesión
                        .logoutSuccessUrl("/login") // Redirigir a la página de login tras logout
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
