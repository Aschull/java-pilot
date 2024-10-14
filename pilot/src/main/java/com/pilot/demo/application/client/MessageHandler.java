package com.pilot.demo.application.client;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


import com.pilot.demo.domain.interfaces.MessageHandlerInterface;

public class MessageHandler implements MessageHandlerInterface {

    //Construtor
    public MessageHandler() {}
    
    //Methods
    public void handler(Socket conn, ServerSocket server, String message) {
        try {
            // Envia uma resposta para o cliente
            OutputStream output = conn.getOutputStream();
            String response = "Olá, cliente!";
            output.write(response.getBytes());
            System.out.println("MessageHandler: Handler: " + message);
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
