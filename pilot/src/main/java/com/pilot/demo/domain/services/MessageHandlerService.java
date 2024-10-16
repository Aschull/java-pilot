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
public class MessageHandlerService implements MessageHandlerInterface {
    private String message = "";
    

    //Getters & Setters
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }


    //Construtor
    public MessageHandlerService(String message) {
        this.message = message;
    }
    
    //Methods
    public void handlerToRabbitMQ(RabbitMQPublisher publisher) {
        try {

            System.out.println("MessageHandler: Handler: " + this.message);
            System.out.println("MessageHandler: Sending message to RabbitMQ");
            publisher.publish(this.message);
            
        } catch (Exception _err) {
            _err.printStackTrace();
        }
    }

    public void handlerToTracker(Socket conn, ServerSocket server) {
        try {
            // Envia uma resposta para o cliente
            OutputStream output = conn.getOutputStream();
            String response = this.message;
            output.write(response.getBytes());

            System.out.println("MessageHandler: Handler: " + this.message);
            System.out.println("MessageHandler: Sending message to Tracker");
            
        } catch (Exception _err) {
            _err.printStackTrace();
            this.closeConn(conn, server);
        }
    }

    public void closeConn(Socket conn, ServerSocket server) {
        try {
            conn.close();
            server.close();
            System.out.println("MessageHandler: Conection closed!!");
        } catch (Exception _err) {
            _err.printStackTrace();
        }
    }


}
