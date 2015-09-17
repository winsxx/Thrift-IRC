package com.cimbel.server.data;

import java.util.*;

public class UserDataManager {

    private static final int MAX_USER = 2 << 20;

    private static UserDataManager dataAccessorSingleton;

    private Map<Integer, String> mIdToNickMapping;
    private Map<String, Integer> mNickToIdMapping;

    private Map<String, Set<Integer>> mChannelUserSetMap;
    private Map<Integer, Set<String>> mUserChannelSetMap;

    private Random mRandom;

    private UserDataManager() {
        mIdToNickMapping = new TreeMap<>();
        mNickToIdMapping = new TreeMap<>();
        mChannelUserSetMap = new TreeMap<>();
        mRandom = new Random();
    }

    public static UserDataManager getInstance() {
        if (dataAccessorSingleton == null) {
            dataAccessorSingleton = new UserDataManager();
        }
        return dataAccessorSingleton;
    }

    public boolean isNicknameExist(String nick) {
        return mNickToIdMapping.containsKey(nick);
    }

    public boolean isUserIdExist(int userId) {
        return mIdToNickMapping.containsKey(userId);
    }

    public int addUser(String nick) {
        if (!isNicknameExist(nick)) {
            int newId = mRandom.nextInt(MAX_USER);
            while (isUserIdExist(newId)) {
                newId = mRandom.nextInt(MAX_USER);
            }
            mIdToNickMapping.put(newId, nick);
            mNickToIdMapping.put(nick, newId);
            mUserChannelSetMap.put(newId, new TreeSet<>());
            return newId;
        } else {
            return -1;
        }
    }

    public boolean removeUser(int userId) {
        if (isUserIdExist(userId)) {
            String nick = mIdToNickMapping.get(userId);
            mIdToNickMapping.remove(userId);
            mNickToIdMapping.remove(nick);
            mUserChannelSetMap.remove(userId);
            return true;
        } else {
            return false;
        }
    }

    public void addUserToChannel(int userId, String channel) {
        if (!mChannelUserSetMap.containsKey(channel)) {
            mChannelUserSetMap.put(channel, new TreeSet<>());
        }

        Set<Integer> userSet = mChannelUserSetMap.get(channel);
        userSet.add(userId);

        if (mUserChannelSetMap.containsKey(userId)) {
            Set<String> channelSet = mUserChannelSetMap.get(userId);
            channelSet.add(channel);
        }
    }

    public void removeUserFromChannel(int userId, String channel) {
        if (mChannelUserSetMap.containsKey(channel)) {
            Set<Integer> userSet = mChannelUserSetMap.get(channel);
            userSet.remove(userId);
            if (userSet.size() == 0) {
                mChannelUserSetMap.remove(channel);
            }
        }
        if (mUserChannelSetMap.containsKey(userId)) {
            Set<String> channelSet = mUserChannelSetMap.get(userId);
            channelSet.remove(channel);
        }
    }

    public List<Integer> getChannelUserList(String channel) {
        return new ArrayList<>(mChannelUserSetMap.get(channel));
    }

    public List<String> getUserChannelList(int userId) {
        return new ArrayList<>(mUserChannelSetMap.get(userId));
    }

}
