package com.pilot.demo.infrastructure.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQConnection {
    private Connection conn;
    private Channel channel;

    public RabbitMQConnection(Connection conn, Channel channel) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("rabbit");
        factory.setPassword("rabbit");
        
        this.setConn(factory.newConnection());
        this.setChannel(this.getConn().createChannel());
    }

    public Channel getChannel() {
        return this.channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Connection getConn() {
        return this.conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void close() throws Exception {
        channel.close();
        conn.close();
    }
}