package jee3060.design.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jee3060.design.model.Hobby;
import lombok.extern.slf4j.Slf4j;
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
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Hobby hobby) {
        try {
            rabbitTemplate.convertAndSend(rabbitQueue, objectMapper.writeValueAsString(hobby));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}
