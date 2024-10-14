package com.pilot.demo.infrastructure.socket;
import java.net.*;
import java.io.*;

public class SocketClient {
    public String startClient() throws IOException {
        // Cria um socket para se conectar ao servidor
        Socket cliente = new Socket("localhost", 8080);
        System.out.println("Conectado ao servidor");

        // Cria um fluxo de entrada e saída
        OutputStream saida = cliente.getOutputStream();
        InputStream entrada = cliente.getInputStream();

        // Envia uma mensagem para o servidor
        String mensagem = "Olá, servidor!";
        saida.write(mensagem.getBytes());

        // Lê a resposta do servidor
        byte[] resposta = new byte[1024];
        entrada.read(resposta);
        String response = new String(resposta);

        // Fecha a conexão
        cliente.close();

        return response;
    }

    public static void main(String[] args) throws IOException {
        SocketClient cliente = new SocketClient();
        String resposta = cliente.startClient();
        System.out.println("Resposta do servidor: " + resposta);
    }
}