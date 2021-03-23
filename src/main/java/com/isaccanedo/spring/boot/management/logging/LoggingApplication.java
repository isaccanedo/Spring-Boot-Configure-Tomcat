package com.isaccanedo.spring.boot.management.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("logging")
@SpringBootApplication
public class LoggingApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class);
    }
}