package com.yuliang.protobuf_rpc;

import com.yuliang.protobuf_rpc.proto.BusinessService;

public interface BusinessServicePB extends BusinessService.BusinessServiceProto.BlockingInterface {
    public static final long versionID=1L;
}
