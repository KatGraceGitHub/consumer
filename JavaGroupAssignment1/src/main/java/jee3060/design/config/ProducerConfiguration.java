package jee3060.design.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfiguration {
    @Value("${ramq.rabbit.queue}")
    private String rabbitQueue;
    @Value("${ramq.rabbit.exchange}")
    private String rabbitExchange;

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public Queue queue() {
        return new Queue(rabbitQueue, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(rabbitExchange);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(topicExchange()).with(rabbitQueue);
    }
}
