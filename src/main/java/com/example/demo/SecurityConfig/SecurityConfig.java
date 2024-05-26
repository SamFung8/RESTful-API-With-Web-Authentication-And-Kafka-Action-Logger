package com.example.demo.SecurityConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //Admin: full permit (create, get, update, delete)
    //SeniorUser: create, get, update
    //NormalUser: get   
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailManager() {
        UserDetails user1 = User
                .withUsername("admin")
                .password("{noop}111")
                .authorities("Admin")
                .build();
        UserDetails user2 = User
                .withUsername("user2")
                .password("{noop}222")
                .authorities("SeniorUser")
                .build();
        UserDetails user3 = User
                .withUsername("user3")
                .password("{noop}333")
                .authorities("NormalUser")
                .build();
        
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
  
}



