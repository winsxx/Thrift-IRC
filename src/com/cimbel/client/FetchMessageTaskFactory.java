package com.cimbel.client;

import com.cimbel.ircservice.MessageService;
import org.apache.thrift.protocol.TProtocol;

/**
 * Created by kevinyu on 9/18/15.
 */
public class FetchMessageTaskFactory {

    private TProtocol mProtocol;

    public FetchMessageTaskFactory(TProtocol protocol) {
        mProtocol = protocol;
    }

    public FetchMessageTask buildMessageTask(int userId) {
        return new FetchMessageTask(userId,new MessageService.Client(mProtocol));
    }
}
