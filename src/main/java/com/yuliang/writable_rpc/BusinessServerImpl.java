package com.yuliang.writable_rpc;

public class BusinessServerImpl implements BusinessProtocol{
    @Override
    public BusinessResponse buy(BusinessRequest br) {
        return new BusinessResponse(br.getBrand() + " " + br.getNum() + " " + br.getPrice());
    }
}
