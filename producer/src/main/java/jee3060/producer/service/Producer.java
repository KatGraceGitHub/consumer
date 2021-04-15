package jee3060.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jee3060.producer.model.Hobby;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {
    @Value("${ramq.rabbit.queue}")
    private String rabbitQueue;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitHandler
    public void send(String jsonHobby) {
        log.info("message sent" + jsonHobby);

        Hobby hobby = new Hobby();
        hobby.setHobbyId(1234);
        hobby.setHobbyName("Test Hobby");
        hobby.setHobbyCategory("Test Category");
        hobby.setHobbyDescription("Test");

        try {
            log.info("Sending hobby message.");
            log.info(hobby.getHobbyName());
            rabbitTemplate.convertAndSend(rabbitQueue, objectMapper.writeValueAsString(hobby));
        }
        catch(JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}
