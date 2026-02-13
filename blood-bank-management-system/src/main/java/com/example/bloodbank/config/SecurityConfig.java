package com.example.bloodbank.config;

import com.example.bloodbank.service.UserDetailsServiceImpl; // <-- Import your new service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService; // <-- 1. Inject your service

    // 2. THIS METHOD IS NEW. It tells Spring Security to use your service and password encoder.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    // 3. THE OLD inMemoryAuthentication() METHOD IS GONE!

   @Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests(requests -> requests
                // Add this line to allow access to CSS, JavaScript, and images
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers("/auth/**").permitAll()
           .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/donors/**").authenticated()
                .anyRequest().authenticated()
        )
        .formLogin(login -> login
                .loginPage("/auth/login")
                .defaultSuccessUrl("/donors/list")
                .permitAll()
        )
        // ... rest of your configuration
        .csrf().disable();
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}