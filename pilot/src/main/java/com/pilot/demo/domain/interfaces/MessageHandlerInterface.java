package com.pilot.demo.domain.interfaces;

import java.net.ServerSocket;
import java.net.Socket;

import com.pilot.demo.infrastructure.rabbitmq.RabbitMQPublisher;

public interface MessageHandlerInterface {

    public void handlerToTracker(Socket conn, ServerSocket server);
    public void handlerToRabbitMQ(RabbitMQPublisher publisher);
    public void closeConn(Socket conn, ServerSocket server);
    
}