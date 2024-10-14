package com.pilot.demo.domain.services;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.pilot.demo.domain.interfaces.MessageHandlerInterface;
import com.pilot.demo.infrastructure.rabbitmq.RabbitMQPublisher;

@Service
@Scope("prototype")
public class MessageHandler implements MessageHandlerInterface {
    private RabbitMQPublisher publisher = null;
    private String message = "";
    private Socket conn = null;
    private ServerSocket server = null;
    

    //Getters & Setters
    public RabbitMQPublisher getPublisher() {
        return this.publisher;
    }

    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public Socket getConn() {
        return this.conn;
    }
    
    public void setConn(Socket conn) {
        this.conn = conn;
    }

    public ServerSocket getServer() {
        return this.server;
    }
    
    public void setServer(ServerSocket server) {
        this.server = server;
    }

    //Construtor
    public MessageHandler(RabbitMQPublisher publisher, String message, Socket conn, ServerSocket server) {
        this.publisher = publisher;
        this.conn = conn;
        this.server = server;
        this.message = message;
    }
    
    //Methods
    public void handler() {
        try {
            // Envia uma resposta para o cliente
            OutputStream output = this.conn.getOutputStream();
            String response = this.message;
            output.write(response.getBytes());
            System.out.println("MessageHandler: Handler: " + this.message);
            System.out.println("MessageHandler: Sending message to RabbitMQ");
            this.publisher.publish(this.message);
            
        } catch (Exception _err) {
            _err.printStackTrace();
            this.closeConn();
        }
    }

    public void closeConn() {
        try {
            this.conn.close();
            this.server.close();
            System.out.println("MessageHandler: Conection closed!!");
        } catch (Exception _err) {
            _err.printStackTrace();
        }
    }
}
