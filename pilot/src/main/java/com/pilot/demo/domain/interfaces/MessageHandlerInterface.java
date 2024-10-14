package com.pilot.demo.domain.interfaces;

import java.net.ServerSocket;
import java.net.Socket;

public interface MessageHandlerInterface {

    public void handler(Socket conn, ServerSocket server, String message);
    public void closeConn(Socket conn, ServerSocket server);
}