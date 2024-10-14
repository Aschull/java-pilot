package com.pilot.demo.infrastructure.socket;
import java.net.*;

import com.pilot.demo.application.client.MessageHandler;
import com.pilot.demo.domain.interfaces.MessageHandlerInterface;

import java.io.*;

public class SocketServer {
    private MessageHandlerInterface messageHandler = new MessageHandler();

    public SocketServer(MessageHandlerInterface messageHandler) {
        this.messageHandler = messageHandler;
    }

    public MessageHandlerInterface getMessageHandler() {
        return this.messageHandler;
    }

    // Constructor
    public SocketServer() {
        this.messageHandler = null;
    }

    public void startServer() throws IOException {
        // Cria um servidor na porta 8080
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Servidor iniciado. Aguardando conexões...");

            // Aceita uma conexão e adiciona a conexão ao servidor
            Socket conn = server.accept();

            System.out.println("Conexão estabelecida com " + conn.getInetAddress());

            while (true) {
                // Cria um fluxo de entrada
                InputStream input = conn.getInputStream();
   
                // Lê a mensagem do cliente
                byte[] byte_message = new byte[1024];
                input.read(byte_message);
                
                String message = new String(byte_message);
                
                System.out.println("SocketServer: Server Message: " + message);
                MessageHandlerInterface messageHandler = this.getMessageHandler();
                messageHandler.handler(conn, server, message);
   
            }
        }
        catch (Exception _err) {
            System.out.println("SocketServer: Exception: " + _err.getMessage());
        }
    }
}