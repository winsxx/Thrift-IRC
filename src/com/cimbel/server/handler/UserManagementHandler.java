package com.cimbel.server.handler;

import com.cimbel.ircservice.UserManagementException;
import com.cimbel.ircservice.UserManagementService;
import com.cimbel.server.data.UserDataManager;
import org.apache.thrift.TException;

public class UserManagementHandler implements UserManagementService.Iface {
    private UserDataManager userDataManager;

    public UserManagementHandler() {
        userDataManager = UserDataManager.getInstance();
    }

    @Override
    public int loginNick(String nick) throws TException {
        return userDataManager.addUser(nick);
    }

    @Override
    public void joinChannel(int userId, String channel) throws TException {
        userDataManager.addUserToChannel(userId, channel);
    }

    @Override
    public void leaveChannel(int userId, String channel) throws TException {
        userDataManager.removeUserFromChannel(userId, channel);
    }

    @Override
    public void logoutUser(int userId) throws TException {
        userDataManager.removeUser(userId);
    }
}
