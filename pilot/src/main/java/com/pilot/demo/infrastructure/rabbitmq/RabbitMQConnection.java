// package com.pilot.demo.infrastructure.rabbitmq;


// import java.io.IOException;
// import java.util.concurrent.TimeoutException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.rabbitmq.client.Channel;
// import com.rabbitmq.client.Connection;
// import com.rabbitmq.client.ConnectionFactory;

// @Service
// public class RabbitMQConnection {
    
//     private ConnectionFactory factory;
//     private Connection conn;
//     private Channel channel;

//     @Autowired
//     public RabbitMQConnection(ConnectionFactory connectionFactory) throws IOException, TimeoutException {
//         ConnectionFactory factory = connectionFactory;
//         Connection conn = connectionFactory.newConnection();
//         Channel channel = conn.createChannel();

//         this.factory = factory;
//         this.conn = conn;
//         this.channel = channel;
//     }

//     public Channel getChannel() {
//         return this.channel;
//     }

//     public void setChannel(Channel channel) {
//         this.channel = channel;
//     }

//     public Connection getConn() {
//         return this.conn;
//     }

//     public Connection setConn(Connection conn) {
//         return this.conn = conn;
//     }

//     public ConnectionFactory getFactory() {
//         return this.factory;
//     }

//     public void close() throws Exception {
//         channel.close();
//         conn.close();
//     }
// }