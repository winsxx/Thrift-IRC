package com.cimbel.server;

import com.cimbel.ircservice.MessageService;
import com.cimbel.ircservice.UserManagementService;
import com.cimbel.server.handler.MessageHandler;
import com.cimbel.server.handler.UserManagementHandler;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class IrcServer {

    public static final int SERVICE_PORT = 8081;
    public static final String USER_MANAGEMENT_SERVICE_NAME = "UserManagement";
    public static final String MESSAGE_SERVICE_NAME = "Message";

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

        BasicConfigurator.configure();

        userManagementHandler = new UserManagementHandler();
        userManagementProcessor = new UserManagementService.Processor<>(userManagementHandler);

        messageHandler = new MessageHandler();
        messageProcessor = new MessageService.Processor<>(messageHandler);

        multiplexedProcessor = new TMultiplexedProcessor();
        multiplexedProcessor.registerProcessor(USER_MANAGEMENT_SERVICE_NAME, userManagementProcessor);
        multiplexedProcessor.registerProcessor(MESSAGE_SERVICE_NAME, messageProcessor);

        try {
            TServerTransport serverTransport = new TServerSocket(SERVICE_PORT);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(multiplexedProcessor));

            System.out.println("Serving UserManagement Service and Message Service...");
            server.serve();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
