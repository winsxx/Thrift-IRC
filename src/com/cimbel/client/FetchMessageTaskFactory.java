package com.cimbel.client;

import com.cimbel.ircservice.MessageService;
import org.apache.thrift.protocol.TProtocol;
import sun.plugin2.message.Message;

/**
 * Created by kevinyu on 9/18/15.
 */
public class FetchMessageTaskFactory {

    private MessageService.Client mFetchMessageClient;

    public FetchMessageTaskFactory(MessageService.Client fetchMessageClient) {
        mFetchMessageClient = fetchMessageClient;
    }

    public FetchMessageTask buildMessageTask(int userId) {
        return new FetchMessageTask(userId,mFetchMessageClient);
    }
}
