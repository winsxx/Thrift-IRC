package com.cimbel.client;

import com.cimbel.ircservice.MessageService;
import com.cimbel.ircservice.UserManagementService;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.ArrayList;

/**
 * Created by kevinyu on 9/18/15.
 */
public class ClientFactory {

    private String mAddress;
    private int mPort;

    private ArrayList<TTransport> transportList;

    public ClientFactory(String address, int port) {
        mAddress = address;
        mPort = port;
        transportList = new ArrayList<>();
    }

    public UserManagementService.Client buildUserServiceClient() throws TTransportException {

        TTransport transport = new TSocket(mAddress,mPort);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        TMultiplexedProtocol multiplexedProtocol = new TMultiplexedProtocol(protocol,"UserManagement");
        UserManagementService.Client userServiceClient = new
                UserManagementService.Client(multiplexedProtocol);

        transportList.add(transport);
        return userServiceClient;
    }

    public MessageService.Client buildMessageServiceClient() throws TTransportException {
        TTransport transport = new TSocket(mAddress,mPort);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        TMultiplexedProtocol multiplexedProtocol = new TMultiplexedProtocol(protocol,"Message");
        MessageService.Client messageServiceClient = new
                MessageService.Client(multiplexedProtocol);

        transportList.add(transport);

        return messageServiceClient;
    }

    public void closeTransport() {
        for (int i=0;i<transportList.size();i++) {
            transportList.get(i).close();
        }
    }
}
