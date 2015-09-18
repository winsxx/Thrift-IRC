package com.cimbel.server.handler;

import com.cimbel.ircservice.UserManagementErrorType;
import com.cimbel.ircservice.UserManagementException;
import com.cimbel.ircservice.UserManagementService;
import com.cimbel.server.data.MessageDataManager;
import com.cimbel.server.data.UserDataManager;
import org.apache.thrift.TException;


import java.util.logging.Logger;

public class UserManagementHandler implements UserManagementService.Iface {
    private static final Logger log = Logger.getLogger( UserManagementService.class.getName() );

    private UserDataManager userDataManager;
    private MessageDataManager messageDataManager;

    public UserManagementHandler() {
        userDataManager = UserDataManager.getInstance();
        messageDataManager = MessageDataManager.getInstance();
    }

    @Override
    public int loginNick(String nick) throws TException {
        log.info("[LOGIN_NICK] " + nick);
        try {
            return userDataManager.addUser(nick);
        } catch (SecurityException se) {
            log.warning("[LOGIN_NICK][NICK_EXIST_ERROR] Nick: " + nick);
            throw new UserManagementException(UserManagementErrorType.NICKNAME_USED,
                    "Nickname has been used by others");
        }
    }

    @Override
    public void joinChannel(int userId, String channel) throws TException {
        log.info("[JOIN_CHANNEL] UserId: " + userId + ", Channel: " +channel);
        if (!userDataManager.isUserIdExist(userId)) {
            log.warning("[JOIN_CHANNEL][NOT_FOUND_ERROR] UserId: " + userId);
            throw new UserManagementException(UserManagementErrorType.USER_ID_NOT_FOUND,
                    "User id not found");
        }
        userDataManager.addUserToChannel(userId, channel);
    }

    @Override
    public void leaveChannel(int userId, String channel) throws TException {
        log.info("[LEAVE_CHANNEL] UserId: " + userId + ", Channel: " +channel);
        if (!userDataManager.isChannelExist(channel)) {
            log.warning("[LEAVE_CHANNEL][NOT_FOUND_ERROR] UserId: " + userId);
            throw new UserManagementException(UserManagementErrorType.CHANNEL_NOT_FOUND,
                    "Channel not found");
        }
        userDataManager.removeUserFromChannel(userId, channel);
    }

    @Override
    public void logoutUser(int userId) throws TException {
        log.info("[LOGOUT_USER] UserId: " + userId);
        if (!userDataManager.isUserIdExist(userId)) {
            log.warning("[LOGOUT_USER][NOT_FOUND_ERROR] UserId: " + userId);
            throw new UserManagementException(UserManagementErrorType.USER_ID_NOT_FOUND,
                    "User id not found");
        }
        messageDataManager.deleteUserMessages(userId);
        userDataManager.removeUser(userId);
    }
}
