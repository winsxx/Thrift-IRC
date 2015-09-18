package com.cimbel.client;

import com.cimbel.ircservice.MessageService;
import com.cimbel.ircservice.UserManagementService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kevinyu on 9/17/15.
 */
public class IRCClient {

    public static void main(String args[]) {

        try {
            TTransport transport;

            transport = new TSocket("localhost", 8081);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            UserManagementService.Client userServiceClient = new
                    UserManagementService.Client(protocol);

            MessageService.Client sendMessageClient = new
                    MessageService.Client(protocol);

            FetchMessageTaskFactory fetchMessageTaskFactory = new FetchMessageTaskFactory(protocol);

            BlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(100);
            InputReaderTask inputReaderTask = new InputReaderTask(messageQueue);

            SendMessageTask sendMessageTask = new SendMessageTask(userServiceClient, sendMessageClient,
                    fetchMessageTaskFactory,messageQueue);

            Thread inputThread = new Thread(inputReaderTask);
            Thread sendMessageThread = new Thread(sendMessageTask);

            Screen.initialize();

            inputThread.start();
            sendMessageThread.start();

            sendMessageThread.join();

            transport.close();

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
