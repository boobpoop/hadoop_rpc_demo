package com.yuliang.writable_rpc;

public interface BusinessProtocol {
    BusinessResponse buy(BusinessRequest br);
    long versionID = 345043000L;
}
