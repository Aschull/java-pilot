package com.pilot.demo.client;
import org.junit.Test;
import org.mockito.Mockito;

import com.pilot.demo.application.client.MessageHandler;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MessageHandlerTest {}

//     @Test
//     public void testHandler() throws Exception {
//         // Crie um mock para o objeto Socket
//         Socket mockSocket = Mockito.mock(Socket.class);

//         // Crie um mock para o objeto OutputStream
//         OutputStream mockOutputStream = Mockito.mock(OutputStream.class);

//         ServerSocket mockServerSocket = Mockito.mock(ServerSocket.class);

//         // Configure o mock para o objeto Socket para retornar o mock para o objeto OutputStream
//         when(mockSocket.getOutputStream()).thenReturn(mockOutputStream);

//         // Crie um objeto MessageHandler para testar
//         MessageHandler messageHandler = new MessageHandler();

//         // Configure o objeto MessageHandler para usar o mock para o objeto Socket

//         // Chame o método handler()
//         messageHandler.handler();

//         // Verifique se o método handler() foi chamado corretamente
//         verify(mockOutputStream, times(1)).write(any(byte[].class));

//         // Verifique se a mensagem foi impressa no console
//         verify(System.out, times(1)).println(anyString());
//     }
// }
