package com.pilot.demo.application.controller;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.demo.application.client.MessageHandler;
import com.pilot.demo.infrastructure.socket.SocketServer;


@RestController
public class PilotOlamundoController {

    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "Alive!";
    }

    @GetMapping("/startServer")
    public void startServer() throws IOException {
        MessageHandler messageHandler = new MessageHandler();
        SocketServer server = new SocketServer(messageHandler);
        server.startServer();
        
    }
}