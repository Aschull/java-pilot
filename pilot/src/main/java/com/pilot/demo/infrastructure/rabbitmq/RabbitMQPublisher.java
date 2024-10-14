package com.pilot.demo.infrastructure.rabbitmq;

import com.rabbitmq.client.Channel;

public class RabbitMQPublisher {
    private RabbitMQConnection conn;
    private String exchange;
    private String routingKey;

    public RabbitMQPublisher(RabbitMQConnection conn, String exchange, String routingKey) {
        this.conn = conn;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public void publish(String message) {
        try {
            Channel channel = conn.getChannel();
            channel.basicPublish(exchange, routingKey, null, message.getBytes());
        } catch (Exception _err) {
            _err.printStackTrace();
        }
    }
}
