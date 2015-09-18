package com.cimbel.server.handler;

import com.cimbel.ircservice.MessageException;
import com.cimbel.ircservice.MessageService;
import com.cimbel.server.data.MessageDataManager;
import com.cimbel.server.data.UserDataManager;
import org.apache.thrift.TException;

import java.util.List;

public class MessageHandler implements MessageService.Iface {
    private MessageDataManager messageDataManager;
    private UserDataManager userDataManager;

    public MessageHandler() {
        messageDataManager = MessageDataManager.getInstance();
        userDataManager = UserDataManager.getInstance();
    }

    @Override
    public void sendMessage(int userId, String message) throws TException {
        List<String> channelList = userDataManager.getUserChannelList(userId);
        for (String channel : channelList) {
            List<Integer> channelUserList = userDataManager.getChannelUserList(channel);
            for (Integer channelUserId : channelUserList) {
                messageDataManager.pushUserMessage(channelUserId, messageFormatting(channel, userId, message));
            }
        }
    }

    @Override
    public void sendMessageToChannel(int userId, String channel, String message) throws TException {
        List<Integer> channelUserList = userDataManager.getChannelUserList(channel);
        for (Integer channelUserId : channelUserList) {
            messageDataManager.pushUserMessage(channelUserId, messageFormatting(channel, userId, message));
        }
    }

    @Override
    public List<String> fetchMessage(int userId) throws TException {
        return messageDataManager.popUserMessages(userId);
    }

    private String messageFormatting(String channel, int senderUserId, String message) {
        String userNick = userDataManager.getUserNick(senderUserId);
        return "[" + channel + "](" + userNick + ") " + message;
    }
}
