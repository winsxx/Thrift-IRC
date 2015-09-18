package com.cimbel.client;

import com.cimbel.ircservice.MessageException;
import com.cimbel.ircservice.MessageService;
import com.cimbel.ircservice.UserManagementException;
import com.cimbel.ircservice.UserManagementService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.concurrent.BlockingQueue;

/**
 * Created by kevinyu on 9/17/15.
 */
public class SendMessageTask implements Runnable{

    private BlockingQueue<String> mInputQueue;
    private UserManagementService.Client mUserServiceClient;
    private MessageService.Client mSendMessageClient;

    private FetchMessageTaskFactory mFetchMessageTaskFactory;
    private FetchMessageTask mFetchMessageTask;

    private int mUserId;

    private static int NOT_LOGIN = -1;
    private enum Command {
        NICK("/NICK"),
        JOIN("/JOIN"),
        LEAVE("/LEAVE"),
        EXIT("/EXIT");

        private String mCommandString;

        private Command(String commandString) {
            this.mCommandString = commandString;
        }

        public String getCommandString() {
            return mCommandString;
        }
    }

    public SendMessageTask(UserManagementService.Client userServiceClient,
                           MessageService.Client messageServiceClient,
                           FetchMessageTaskFactory fetchMessageTaskFactory,
                           BlockingQueue<String> inputQueue) {

        mInputQueue = inputQueue;
        mUserServiceClient = userServiceClient;
        mSendMessageClient = messageServiceClient;
        mFetchMessageTaskFactory = fetchMessageTaskFactory;
        mUserId = NOT_LOGIN;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String inputString = mInputQueue.take();

                String commandString = getCommand(inputString);

                if (commandString.equals(Command.NICK.getCommandString())) {
                    if (mUserId == -1) {
                        String nick = getPayload(inputString);
                        mUserId = mUserServiceClient.loginNick(nick);

                        mFetchMessageTask = mFetchMessageTaskFactory.buildMessageTask(mUserId);
                        mFetchMessageTask.start();

                        Screen.printNotification("[SUCCESS] Login successful");
                    } else {
                        Screen.printNotification("[ERROR] You have login before. Exit this application and try again.");
                    }

                } else if (commandString.equals(Command.EXIT.getCommandString())) {
                    if (mUserId != NOT_LOGIN) {
                        mUserServiceClient.logoutUser(mUserId);
                        mFetchMessageTask.stop();
                    }
                    break;

                }else if (mUserId == NOT_LOGIN) {

                    Screen.printNotification("[ERROR] You need to login. Please login and try again.");

                } else if (commandString.equals(Command.JOIN.getCommandString())) {
                    String channel = getPayload(inputString);
                    mUserServiceClient.joinChannel(mUserId, channel);

                    Screen.printNotification("[SUCCESS] You join channel " + channel + " successfully");

                } else if (commandString.equals(Command.LEAVE.getCommandString())) {
                    String channel = getPayload(inputString);
                    mUserServiceClient.leaveChannel(mUserId, channel);

                    Screen.printNotification("[SUCCESS] You leave channel " + channel + " successfully");
                } else {

                    if (commandString.charAt(0) == '@') {
                        String channelName = commandString.substring(1);
                        String message = getPayload(inputString);
                        mSendMessageClient.sendMessageToChannel(mUserId, channelName, message);
                    } else {
                        mSendMessageClient.sendMessage(mUserId, inputString);
                    }

                }
            } catch (Exception e) {
                Screen.printNotification("[ERROR]" + e.getMessage());
            }
        }
    }

    private static String getCommand(String inputString) {
        int whitespaceIndex = inputString.indexOf(' ');
        if (whitespaceIndex == -1) return inputString;

        return inputString.substring(0,whitespaceIndex);
    }

    private static String getPayload(String inputString) {
        int whitespaceIndex = inputString.indexOf(' ');
        if (whitespaceIndex == -1) return "";

        return inputString.substring(inputString.indexOf(' ')+1);
    }
}
