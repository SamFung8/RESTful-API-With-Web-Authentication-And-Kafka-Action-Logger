package com.example.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/1")
	public String indexPage() {
            return "home.html";
	}

        @RequestMapping("/2")
	public String homePage() {
            return "home.html";
	}
}