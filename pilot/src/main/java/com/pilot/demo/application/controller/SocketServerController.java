package com.pilot.demo.application.controller;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.demo.domain.services.MessageHandler;
import com.pilot.demo.infrastructure.rabbitmq.RabbitMQConnection;
import com.pilot.demo.infrastructure.rabbitmq.RabbitMQPublisher;
import com.pilot.demo.infrastructure.socket.SocketServer;


@RestController
public class SocketServerController {

    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "Alive!";
    }

    @GetMapping("/startServer")
    public void startServer() throws IOException, TimeoutException {
        RabbitMQConnection conn = new RabbitMQConnection(null, null);
        RabbitMQPublisher publisher = new RabbitMQPublisher(conn, "my_exchange", "my_routing_key");
        MessageHandler messageHandler = new MessageHandler(publisher, null, null, null);
        SocketServer server = new SocketServer(messageHandler);
        server.startServer();
        
    }
}