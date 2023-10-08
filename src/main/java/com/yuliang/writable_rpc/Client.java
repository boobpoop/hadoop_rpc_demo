package com.yuliang.writable_rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        BusinessProtocol proxy = RPC.getProxy(BusinessProtocol.class, BusinessProtocol.versionID, new InetSocketAddress("localhost", 12345), new Configuration());
        BusinessResponse result = proxy.buy(new BusinessRequest("apple", 1, 11000));
        System.out.println(result);
    }
}
