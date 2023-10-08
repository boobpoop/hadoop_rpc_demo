package com.yuliang.writable_rpc;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class BusinessResponse implements Writable {
    private String result;

    public BusinessResponse() {
    }

    public BusinessResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BusinessResponse{" +
                "result='" + result + '\'' +
                '}';
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.result);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.setResult(dataInput.readUTF());
    }
}
