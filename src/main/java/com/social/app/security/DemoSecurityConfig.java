package com.social.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import javax.sql.DataSource;

//@Configuration
//public class DemoSecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
//        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE,MANAGER").build();
//        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE,MANAGER, ADMIN").build();
//        return new InMemoryUserDetailsManager(john, mary, susan);
//    }


    //add support for jdbc users
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from p_user where user_id=?");
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, roles from role where user_id=?");
//        return jdbcUserDetailsManager;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests(configure -> configure
//                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/api/employees")).hasRole("EMPLOYEE")
//                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/api/employees/**")).hasRole("EMPLOYEE")
//                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/api/employees")).hasRole("MANAGER")
//                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.PUT, "/api/employees")).hasRole("MANAGER")
//                .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.DELETE, "/api/employees")).hasRole("ADMIN"));
//        http.httpBasic(Customizer.withDefaults());
//        http.csrf(AbstractHttpConfigurer::disable);
//        return http.build();
//    }
//}
