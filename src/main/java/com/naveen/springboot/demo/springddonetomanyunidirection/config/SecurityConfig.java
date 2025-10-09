package com.naveen.springboot.demo.springddonetomanyunidirection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

public class SecurityConfig {
    // Use this for custom name tables for spring boot security using DB
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

//        define a query to retrieve a user by username/user_id
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

//        define a query to retrieve the authority/role by username/user_id
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        CSRF - Cross-Site Request Forgery
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PATCH, "/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("EMPLOYEE")
        );

//        use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());
//        In general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable()); // 🔑 disable CSRF for Postman testing
        return http.build();
    }
}
