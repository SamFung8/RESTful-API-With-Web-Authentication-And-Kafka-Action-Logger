package com.example.demo.MVCConfig;

import com.example.demo.ExceptionConfig.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        //registry.addViewController("/login").setViewName("login.html");

        registry.addViewController("/addProduct").setViewName("addProduct");
        registry.addViewController("/deleteProduct").setViewName("deleteProduct");
        registry.addViewController("/updateProduct").setViewName("updateProduct");
        registry.addViewController("/getProduct").setViewName("getProduct");

        registry.addViewController("/actionPage").setViewName("actionPage");
    }
    
    
    //Admin: full permit (create, get, update, delete)
    //SeniorUser: create, get, update
    //NormalUser: get
    
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .formLogin(Customizer.withDefaults())
            .authorizeHttpRequests(requests -> requests
                    .antMatchers(HttpMethod.GET, "/addProduct").hasAnyAuthority("Admin", "SeniorUser")
                    .antMatchers(HttpMethod.GET, "/updateProduct").hasAnyAuthority("Admin", "SeniorUser")
                    .antMatchers(HttpMethod.GET, "/deleteProduct").hasAnyAuthority("Admin")
                    .anyRequest().permitAll()
            )
            .exceptionHandling()
            .accessDeniedHandler(new CustomAccessDeniedHandler())
            .and()
            .csrf()
            .ignoringAntMatchers("/api/v1/**/")
            .ignoringAntMatchers("/actionPage");
        
        return httpSecurity.build();
    }

}
