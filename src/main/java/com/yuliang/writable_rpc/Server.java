package com.yuliang.writable_rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;


public class Server {
    public static void main(String[] args) throws IOException {
        RPC.Server server = new RPC.Builder(new Configuration())
                .setProtocol(BusinessProtocol.class)
                .setInstance(new BusinessServerImpl())
                .setBindAddress("localhost")
                .setPort(12345)
                .build();
        server.start();
    }
}
