package com.example.springboot_demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String login() {
        // Maps to src/main/resources/templates/login.html
        return "login";
    }
    
    @GetMapping("/home")
    public String home() {
        // Maps to src/main/resources/templates/home.html (for success redirect)
        return "preact";
    }
	
    @GetMapping("/")
    public String index() {
        return "preact";
    }
	
    @GetMapping("/additem")
    public String add_item() {
        return "ts-react";
    }
}
