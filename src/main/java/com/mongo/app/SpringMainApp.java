package com.mongo.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.mongo.ctlr")
@SpringBootApplication
public class SpringMainApp {
 public static void main(String[] args) {
     SpringApplication.run(SpringMainApp.class, args);
        }
    }
