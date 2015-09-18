package com.cimbel.server.data;

import java.util.*;

public class MessageDataManager {

    private static MessageDataManager mDataManagerSingleton;

    private Map<Integer, Queue<String>> mUserMessageQueueMap;

    private MessageDataManager() {
        mUserMessageQueueMap = new TreeMap<>();
    }

    public static MessageDataManager getInstance() {
        if (mDataManagerSingleton == null) {
            mDataManagerSingleton = new MessageDataManager();
        }
        return mDataManagerSingleton;
    }

    public boolean isUserHaveMessages(int userId) {
        return mUserMessageQueueMap.containsKey(userId) && (mUserMessageQueueMap.get(userId).size() > 0);
    }

    public List<String> popUserMessages(int userId) {
        Queue<String> messagesQueue = mUserMessageQueueMap.get(userId);
        List<String> messagesList = new ArrayList<>(messagesQueue);
        mUserMessageQueueMap.remove(userId);
        return messagesList;
    }

    public void pushUserMessage(int userId, String message) {
        if (!mUserMessageQueueMap.containsKey(userId)) {
            mUserMessageQueueMap.put(userId, new LinkedList<>());
        }
        Queue<String> messagesQueue = mUserMessageQueueMap.get(userId);
        messagesQueue.add(message);
    }

    public void deleteUserMessages(int userId) {
        if (mUserMessageQueueMap.containsKey(userId)) {
            mUserMessageQueueMap.remove(userId);
        }
    }
}
