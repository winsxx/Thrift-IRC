package com.cimbel.server.data;

import java.util.*;

public class UserDataManager {

    private static final int MAX_USER = 2 << 20;

    private static UserDataManager mDataManagerSingleton;
    private final Object idNickLock;
    private final Object userChannelLock;
    private final Random mRandom;
    private Map<Integer, String> mIdToNickMapping;
    private Map<String, Integer> mNickToIdMapping;
    private Map<String, Set<Integer>> mChannelUserSetMap;
    private Map<Integer, Set<String>> mUserChannelSetMap;

    private UserDataManager() {
        mIdToNickMapping = new TreeMap<>();
        mNickToIdMapping = new TreeMap<>();
        mChannelUserSetMap = new TreeMap<>();
        mUserChannelSetMap = new TreeMap<>();

        mRandom = new Random();

        idNickLock = new Object();
        userChannelLock = new Object();
    }

    public static synchronized UserDataManager getInstance() {
        if (mDataManagerSingleton == null) {
            mDataManagerSingleton = new UserDataManager();
        }
        return mDataManagerSingleton;
    }

    public boolean isNicknameExist(String nick) {
        synchronized (idNickLock) {
            return mNickToIdMapping.containsKey(nick);
        }
    }

    public boolean isUserIdExist(int userId) {
        synchronized (idNickLock) {
            return mIdToNickMapping.containsKey(userId);
        }
    }

    public int addUser(String nick) throws SecurityException {
        synchronized (idNickLock) {
            if (!mNickToIdMapping.containsKey(nick)) {
                int newId = mRandom.nextInt(MAX_USER);
                while (mIdToNickMapping.containsKey(newId)) {
                    newId = mRandom.nextInt(MAX_USER);
                }
                mIdToNickMapping.put(newId, nick);
                mNickToIdMapping.put(nick, newId);
                synchronized (userChannelLock) {
                    mUserChannelSetMap.put(newId, new TreeSet<>());
                }
                return newId;
            } else {
                throw new SecurityException("Nickname " + nick + " is not available");
            }
        }
    }

    public String generateNick(){
        synchronized (idNickLock){
            int uniqueInt = mRandom.nextInt(MAX_USER);
            String nick = "user-"+uniqueInt;
            while (mNickToIdMapping.containsKey(nick)){
                uniqueInt = mRandom.nextInt(MAX_USER);
                nick = "user-"+uniqueInt;
            }
            return nick;
        }
    }

    public String getUserNick(int userId) {
        synchronized (idNickLock) {
            return mIdToNickMapping.get(userId);
        }
    }

    public int getUserIdFromNick(String nick) throws IllegalArgumentException{
        synchronized (idNickLock){
            if(!mNickToIdMapping.containsKey(nick)){
                return mNickToIdMapping.get(nick);
            } else {
                throw new IllegalArgumentException("Nick not available");
            }
        }
    }

    public boolean removeUser(int userId) {
        synchronized (idNickLock) {
            if (mIdToNickMapping.containsKey(userId)) {
                String nick = mIdToNickMapping.get(userId);
                mIdToNickMapping.remove(userId);
                mNickToIdMapping.remove(nick);
                synchronized (userChannelLock) {
                    mUserChannelSetMap.remove(userId);
                }
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isChannelExist(String channel) {
        synchronized (userChannelLock) {
            return mChannelUserSetMap.containsKey(channel);
        }
    }

    public boolean isChannelMember(int userId, String channel) {
        synchronized (userChannelLock) {
            if (mChannelUserSetMap.containsKey(channel)) {
                Set<String> channelSet = mUserChannelSetMap.get(userId);
                return channelSet.contains(channel);
            } else {
                return false;
            }
        }
    }

    public void addUserToChannel(int userId, String channel) {
        synchronized (userChannelLock) {
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
    }

    public void removeUserFromChannel(int userId, String channel) {
        synchronized (userChannelLock) {
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
    }

    public List<Integer> getChannelUserList(String channel) {
        synchronized (userChannelLock) {
            return new ArrayList<>(mChannelUserSetMap.get(channel));
        }
    }

    public List<String> getUserChannelList(int userId) {
        synchronized (userChannelLock) {
            return new ArrayList<>(mUserChannelSetMap.get(userId));
        }
    }

}
