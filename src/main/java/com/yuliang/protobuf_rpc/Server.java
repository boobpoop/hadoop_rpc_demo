package com.yuliang.protobuf_rpc;


import com.yuliang.protobuf_rpc.proto.BusinessService;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtobufRpcEngine;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        RPC.setProtocolEngine(conf, BusinessServicePB.class, ProtobufRpcEngine.class);

        RPC.Server server = new RPC.Builder(conf)
                .setProtocol(BusinessServicePB.class)
                .setInstance(BusinessService.BusinessServiceProto.newReflectiveBlockingService(new BusinessServerPBImpl()))
                .setBindAddress("localhost")
                .setPort(12345)
                .build();
        server.start();
    }
}
