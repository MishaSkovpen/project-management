package com.skovpenma.projectmanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
// import com.skovpenma.projectmanagement.service.CustomUserDetailsService;
// import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /*
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Новий спосіб вимкнення CSRF
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/users/register").permitAll()
                        //.requestMatchers("/api/projects/**").permitAll()
                        .requestMatchers("/login", "/register").permitAll()
                        .requestMatchers("/", "/style.css").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        //.defaultSuccessUrl("/hello", true)
                        .permitAll()
                )
                .logout((logout) -> {
                    logout
                            .invalidateHttpSession(true)
                            .clearAuthentication(true)
                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                            .logoutSuccessUrl("/login?logout")
                            .permitAll();
                });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

