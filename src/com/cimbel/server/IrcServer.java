package com.cimbel.server;

import com.cimbel.ircservice.MessageService;
import com.cimbel.ircservice.UserManagementService;
import com.cimbel.server.handler.MessageHandler;
import com.cimbel.server.handler.UserManagementHandler;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class IrcServer {

    public static UserManagementHandler userManagementHandler;
    public static UserManagementService.Processor<UserManagementHandler> userManagementProcessor;

    public static MessageHandler messageHandler;
    public static MessageService.Processor<MessageHandler> messageProcessor;

    /**
     * Support for Multiplexing Services on any Transport, Protocol and Server
     * https://issues.apache.org/jira/browse/THRIFT-563
     */
    public static TMultiplexedProcessor multiplexedProcessor;


    public static void main(String[] args) {
        try {
            userManagementHandler = new UserManagementHandler();
            userManagementProcessor = new UserManagementService.Processor<>(userManagementHandler);

            messageHandler = new MessageHandler();
            messageProcessor = new MessageService.Processor<>(messageHandler);

            multiplexedProcessor = new TMultiplexedProcessor();
            multiplexedProcessor.registerProcessor("UserManagement", userManagementProcessor);
            multiplexedProcessor.registerProcessor("Message", messageProcessor);

            TServerTransport serverTransport = new TServerSocket(8081);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(multiplexedProcessor));

            System.out.println("Serving UserManagement Service and Message Service...");
            server.serve();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
