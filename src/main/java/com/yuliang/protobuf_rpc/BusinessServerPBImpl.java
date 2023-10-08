package com.yuliang.protobuf_rpc;

import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import com.yuliang.protobuf_rpc.proto.Business;


public class BusinessServerPBImpl implements BusinessServicePB {
    @Override
    public Business.BusinessResponseProto buy(RpcController controller, Business.BusinessRequestProto request) throws ServiceException {
        String result = request.getBrand() + " " + request.getNum() + " " + request.getPrice();
        return Business.BusinessResponseProto.newBuilder().setResult(result).build();
    }
}
