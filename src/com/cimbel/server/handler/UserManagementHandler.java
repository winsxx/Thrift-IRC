package com.cimbel.server.handler;

import com.cimbel.ircservice.UserManagementErrorType;
import com.cimbel.ircservice.UserManagementException;
import com.cimbel.ircservice.UserManagementService;
import com.cimbel.server.data.MessageDataManager;
import com.cimbel.server.data.UserDataManager;
import org.apache.thrift.TException;

public class UserManagementHandler implements UserManagementService.Iface {
    private UserDataManager userDataManager;
    private MessageDataManager messageDataManager;

    public UserManagementHandler() {
        userDataManager = UserDataManager.getInstance();
        messageDataManager = MessageDataManager.getInstance();
    }

    @Override
    public int loginNick(String nick) throws TException {
        try {
            return userDataManager.addUser(nick);
        } catch (SecurityException se) {
            throw new UserManagementException(UserManagementErrorType.NICKNAME_USED,
                    "Nickname has been used by others");
        }
    }

    @Override
    public void joinChannel(int userId, String channel) throws TException {
        if (!userDataManager.isUserIdExist(userId)) {
            throw new UserManagementException(UserManagementErrorType.USER_ID_NOT_FOUND,
                    "User id not found");
        }
        userDataManager.addUserToChannel(userId, channel);
    }

    @Override
    public void leaveChannel(int userId, String channel) throws TException {
        if (!userDataManager.isChannelExist(channel)) {
            throw new UserManagementException(UserManagementErrorType.CHANNEL_NOT_FOUND,
                    "Channel not found");
        }
        userDataManager.removeUserFromChannel(userId, channel);
    }

    @Override
    public void logoutUser(int userId) throws TException {
        if (!userDataManager.isUserIdExist(userId)) {
            throw new UserManagementException(UserManagementErrorType.USER_ID_NOT_FOUND,
                    "User id not found");
        }
        messageDataManager.deleteUserMessages(userId);
        userDataManager.removeUser(userId);
    }
}
