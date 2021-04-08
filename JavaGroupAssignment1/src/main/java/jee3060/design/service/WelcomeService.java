package jee3060.design.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    @Value("${my.name}")
    private String name;


    public String welcomeMessage() {
        return "Welcome to Spring project, " + name + "!";
    }
}
