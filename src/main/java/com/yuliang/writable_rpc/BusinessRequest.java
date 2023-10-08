package com.yuliang.writable_rpc;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class BusinessRequest implements Writable {

    private String brand;
    private long num;
    private double price;

    public BusinessRequest() {
    }

    public BusinessRequest(String brand, long num, double price) {
        this.brand = brand;
        this.num = num;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessRequest that = (BusinessRequest) o;
        return num == that.num && Double.compare(that.price, price) == 0 && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, num, price);
    }

    @Override
    public String toString() {
        return "BusinessRequest{" +
                "brand='" + brand + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.getBrand());
        dataOutput.writeLong(this.getNum());
        dataOutput.writeDouble(this.getPrice());
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.setBrand(dataInput.readUTF());
        this.setNum(dataInput.readLong());
        this.setPrice(dataInput.readDouble());
    }
}

