package jee3060.design;

import jee3060.design.model.Hobby;
import jee3060.design.service.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class HobbiesApplication {


    public static void main(String[] args) {
        //ConfigurableApplicationContext ctx =  SpringApplication.run(HobbiesApplication.class, args);

        SpringApplication.run(HobbiesApplication.class, args);
    }

    @Autowired
    private Producer producer;

    @Bean
    public void sendMessage() {
        log.info("Send message ........");
        Hobby hobby = new Hobby();
        hobby.setHobbyName("Ice fishing");
        hobby.setHobbyDescription("I like to catch frozen fishies");
        hobby.setHobbyCategory("Outdoors");
        producer.sendMessage(hobby);
    }
}

