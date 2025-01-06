package com.pilot.demo.infrastructure.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

@Service
public class RabbitMQPublisher {

    private ConnectionFactory factory;

    @Autowired
    private String exchange;

    @Autowired
    private String routingKey;
    
    @Autowired
    public RabbitMQPublisher(ConnectionFactory factory) throws IOException, TimeoutException {
        this.factory = factory;
    }

    public ConnectionFactory getFactory() {
        return this.factory;
    }

    public void publish(String message) {
        try {
            Channel channel = this.getFactory().newConnection().createChannel();
            channel.basicPublish(exchange, routingKey, null, message.getBytes());
        } catch (Exception _err) {
            _err.printStackTrace();
        }
    }
}
