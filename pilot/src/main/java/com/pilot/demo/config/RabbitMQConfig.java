package com.pilot.demo.config;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pilot.demo.infrastructure.rabbitmq.RabbitMQPublisher;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

@Configuration
public class RabbitMQConfig {
 
    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("rabbit");
        factory.setPassword("rabbit");
        return factory;
    }
    
    @Bean
    public RabbitMQPublisher rabbitMQPublisher() throws IOException, TimeoutException {
        return new RabbitMQPublisher(connectionFactory());
    }

 
    // @Bean
    // public Connection connection() throws IOException, TimeoutException {
    //     return connectionFactory().newConnection();
    // }
 
    // @Bean
    // public Channel channel() throws IOException, TimeoutException {
    //     return connection().createChannel();
    // }

    @Bean
    public String exchange() {
        return "my_exchange";
    }

    @Bean
    public String routingKey() {
        return "my_routing_key";
    }

    @Bean
    public String rawMessage() {
        return "";
    }
}