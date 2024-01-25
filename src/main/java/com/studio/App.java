package com.studio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/app");
        SpringApplication.run(App.class, args);

        System.out.println("Hello! The application has started!");
    }

}
