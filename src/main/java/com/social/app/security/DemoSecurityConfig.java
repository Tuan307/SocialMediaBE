package com.social.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE,MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE,MANAGER,ADMIN").build();
        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(configurer -> configurer
                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/api/employees")).hasRole("EMPLOYEE")
                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/api/employees/**")).hasRole("EMPLOYEE")
                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/api/employees")).hasRole("MANAGER")
                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.PUT, "/api/employees")).hasRole("MANAGER")
                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.DELETE, "/api/employees")).hasRole("ADMIN"));
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
