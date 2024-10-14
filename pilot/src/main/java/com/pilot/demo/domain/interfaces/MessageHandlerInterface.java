package com.pilot.demo.domain.interfaces;

import java.net.ServerSocket;
import java.net.Socket;

public interface MessageHandlerInterface {

    public void handler();
    public void closeConn();
    public void setMessage(String message);
    public void setConn(Socket conn);
    public void setServer(ServerSocket server);
    
}