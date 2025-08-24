package com.studentform.security;

import com.studentform.service.CustomAdminDetailsService;
import com.studentform.service.CustomAdminCellDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.*;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private CustomAdminCellDetailsService adminCellUserDetailsService;

    @Autowired
    private CustomAdminDetailsService adminUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/students").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/login", "/api/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/admincell/login", "/api/auth/admincell/register").permitAll()

                        // 👇 Allow "views" BEFORE blocking all /api/admin/**
                        .requestMatchers(HttpMethod.GET, "/api/admin/students/views").permitAll()

                        .requestMatchers("/api/admincell/**").hasRole("ADMIN_CELL")
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/admin").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/admincell").hasRole("ADMIN_CELL")
                        .requestMatchers(HttpMethod.GET, "/api/admin/students").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/admincell/students").hasRole("ADMIN_CELL")
                        .requestMatchers(HttpMethod.GET, "/api/admin/students/{id}/export/{type}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/admin/students/exports/excel", "/api/admin/students/exports/pdf").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/api/admincell/students/{id}/remark").hasRole("ADMIN_CELL")
                        .anyRequest().authenticated()
                )
                .authenticationManager(authenticationManager()); // Explicitly set the custom manager
        // Note: The two authenticationProvider() calls below are removed
        // because the AuthenticationManager is now explicitly defined with both providers.

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    // This bean correctly wires up both user details services
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(
                adminAuthenticationProvider(),
                adminCellAuthenticationProvider()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider adminAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(adminUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public DaoAuthenticationProvider adminCellAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(adminCellUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:3001"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}