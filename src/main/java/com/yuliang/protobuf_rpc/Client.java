package com.yuliang.protobuf_rpc;

import com.google.protobuf.ServiceException;
import com.yuliang.protobuf_rpc.proto.Business;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtobufRpcEngine;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) throws IOException, ServiceException {

        Configuration conf = new Configuration();
        RPC.setProtocolEngine(conf, BusinessServicePB.class, ProtobufRpcEngine.class);
        BusinessServicePB proxy = RPC.getProxy(BusinessServicePB.class, BusinessServicePB.versionID, new InetSocketAddress("localhost", 12345), conf);
        Business.BusinessResponseProto result = proxy.buy(null, Business.BusinessRequestProto.newBuilder().setBrand("apple").setNum(1).setPrice(12300).build());
        System.out.println(result);
    }
}
