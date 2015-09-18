package com.cimbel.client;

import com.cimbel.ircservice.MessageService;
import com.cimbel.ircservice.UserManagementService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kevinyu on 9/17/15.
 */
public class IRCClient {

    public static void main(String args[]) {

        try {

            ClientFactory clientFactory = new ClientFactory("localhost",8081);

            UserManagementService.Client userServiceClient = clientFactory.buildUserServiceClient();
            MessageService.Client sendMessageClient = clientFactory.buildMessageServiceClient();

            FetchMessageTaskFactory fetchMessageTaskFactory = new FetchMessageTaskFactory(
                    clientFactory.buildMessageServiceClient());

            BlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(100);
            ReadInputTask inputReaderTask = new ReadInputTask(messageQueue);

            SendMessageTask sendMessageTask = new SendMessageTask(userServiceClient, sendMessageClient,
                    fetchMessageTaskFactory,messageQueue);

            Thread inputThread = new Thread(inputReaderTask);
            Thread sendMessageThread = new Thread(sendMessageTask);

            Screen.initialize();

            inputThread.start();
            sendMessageThread.start();

            sendMessageThread.join();

            clientFactory.closeTransport();

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
