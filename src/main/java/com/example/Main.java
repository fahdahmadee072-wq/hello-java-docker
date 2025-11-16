package com.example;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Main {

    @RequestMapping("/")
    String home() {
        return "Hello from Spring Boot in Docker!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
