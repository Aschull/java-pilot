package com.pilot.demo.application.controller;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.demo.domain.services.TrackerIdentifierService;
// import com.pilot.demo.infrastructure.rabbitmq.RabbitMQConnection;
import com.pilot.demo.infrastructure.rabbitmq.RabbitMQPublisher;
import com.pilot.demo.infrastructure.socket.SocketServer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


@RestController
public class SocketServerController {
    @Autowired
    private RabbitMQPublisher publisher;


    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "Alive!";
    }

    @GetMapping("/startServer")
    public void startServer() throws IOException, TimeoutException {
        // RabbitMQConnection connection = new RabbitMQConnection(null);
        // Connection conn = connection.getConn();
        // Channel channel = connection.getChannel();
        // RabbitMQPublisher publisher = new RabbitMQPublisher(conn, channel, "my_exchange", "my_routing_key");
        
        TrackerIdentifierService trackerIdentifier = new TrackerIdentifierService("", publisher);
        SocketServer server = new SocketServer(trackerIdentifier);
        server.startServer();
        
    }
}