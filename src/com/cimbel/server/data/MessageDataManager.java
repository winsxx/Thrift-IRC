package com.cimbel.server.data;

import java.util.*;

public class MessageDataManager {

    private static MessageDataManager mDataManagerSingleton;
    private final Object mapLock;
    private Map<Integer, List<String>> mUserMessageListMap;

    private MessageDataManager() {
        mUserMessageListMap = new TreeMap<>();
        mapLock = new Object();
    }

    public static synchronized MessageDataManager getInstance() {
        if (mDataManagerSingleton == null) {
            mDataManagerSingleton = new MessageDataManager();
        }
        return mDataManagerSingleton;
    }

    public List<String> popUserMessages(int userId) {
        synchronized (mapLock) {
            if (isUserHaveMessages(userId)) {
                List<String> messagesSyncList = mUserMessageListMap.get(userId);
                List<String> messagesList = new ArrayList<>(messagesSyncList);
                mUserMessageListMap.remove(userId);
                return messagesList;
            } else {
                return new ArrayList<>();
            }
        }
    }

    public void pushUserMessage(int userId, String message) {
        synchronized (mapLock) {
            if (!mUserMessageListMap.containsKey(userId)) {
                mUserMessageListMap.put(userId, new LinkedList<>());
            }
            List<String> messagesList = mUserMessageListMap.get(userId);
            messagesList.add(message);
        }
    }

    public void deleteUserMessages(int userId) {
        synchronized (mapLock) {
            if (mUserMessageListMap.containsKey(userId)) {
                mUserMessageListMap.remove(userId);
            }
        }
    }

    private boolean isUserHaveMessages(int userId) {
        return mUserMessageListMap.containsKey(userId) && (mUserMessageListMap.get(userId).size() > 0);
    }
}
