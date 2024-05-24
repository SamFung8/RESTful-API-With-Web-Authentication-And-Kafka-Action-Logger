package com.example.demo.MVCConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

        @Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		//registry.addViewController("/login").setViewName("login.html");
                
                registry.addViewController("/addProduct").setViewName("addProduct");
                registry.addViewController("/deleteProduct").setViewName("deleteProduct");
                registry.addViewController("/updateProduct").setViewName("updateProduct");
                registry.addViewController("/getProduct").setViewName("getProduct");
                
                registry.addViewController("/errorPage").setViewName("errorPage");
                registry.addViewController("/successActionPage").setViewName("successActionPage");
	}

}
