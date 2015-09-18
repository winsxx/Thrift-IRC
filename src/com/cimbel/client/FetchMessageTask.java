package com.cimbel.client;

import com.cimbel.ircservice.MessageException;
import com.cimbel.ircservice.MessageService;
import org.apache.thrift.TException;
import sun.plugin2.message.Message;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kevinyu on 9/18/15.
 */
public class FetchMessageTask {

    private int mUserId;
    private MessageService.Client mFetchMessageClient;
    Timer mTimer;

    FetchTask mFetchTask;

    public FetchMessageTask(int userId, MessageService.Client fetchMessageClient) {
        mUserId = userId;
        mFetchMessageClient = fetchMessageClient;

        mTimer = new Timer();
        mFetchTask = new FetchTask();

    }

    private class FetchTask extends TimerTask {
        @Override
        public void run() {
            try {
                List<String> messages = mFetchMessageClient.fetchMessage(mUserId);
                for (int i=0;i<messages.size();i++) {
                    Screen.printMessage(messages.get(i));
                }
            } catch (TException e) {

            }
        }
    }

    public void start() {
        mTimer.scheduleAtFixedRate(mFetchTask,0,15*1000);
    }


    public void stop() {
        mTimer.cancel();
    }

}
