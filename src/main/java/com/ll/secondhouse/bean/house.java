package com.ll.secondhouse.bean;

public class house {
    private int h_id;
    private String h_name;
    private String h_address;
    private String h_produce;
    private String h_date;
    //  1表示未审核，2表示 已经审核但是没有被预定，3表示已经被预订但是没有付尾款，4表示已经付清了尾款
    private int h_state;
    private double h_price;
    private int h_user_id;
    // 在没有预定的或者没有购买的情况下， h_user_id = h_buyer_id
    private int h_buyer_id;

    public house(int h_id, String h_name, String h_address, String h_produce, String h_date, int h_state, double h_price, int h_user_id, int h_buyer_id) {
        this.h_id = h_id;
        this.h_name = h_name;
        this.h_address = h_address;
        this.h_produce = h_produce;
        this.h_date = h_date;
        this.h_state = h_state;
        this.h_price = h_price;
        this.h_user_id = h_user_id;
        this.h_buyer_id = h_buyer_id;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getH_address() {
        return h_address;
    }

    public void setH_address(String h_address) {
        this.h_address = h_address;
    }

    public String getH_produce() {
        return h_produce;
    }

    public void setH_produce(String h_produce) {
        this.h_produce = h_produce;
    }

    public String getH_date() {
        return h_date;
    }

    public void setH_date(String h_date) {
        this.h_date = h_date;
    }

    public int getH_state() {
        return h_state;
    }

    public void setH_state(int h_state) {
        this.h_state = h_state;
    }

    public double getH_price() {
        return h_price;
    }

    public void setH_price(double h_price) {
        this.h_price = h_price;
    }

    public int getH_user_id() {
        return h_user_id;
    }

    public void setH_user_id(int h_user_id) {
        this.h_user_id = h_user_id;
    }

    public int getH_buyer_id() {
        return h_buyer_id;
    }

    public void setH_buyer_id(int h_buyer_id) {
        this.h_buyer_id = h_buyer_id;
    }

    @Override
    public String toString() {
        return "house{" +
                "h_id=" + h_id +
                ", h_name='" + h_name + '\'' +
                ", h_address='" + h_address + '\'' +
                ", h_produce='" + h_produce + '\'' +
                ", h_date='" + h_date + '\'' +
                ", h_state=" + h_state +
                ", h_price=" + h_price +
                ", h_user_id=" + h_user_id +
                ", h_buyer_id=" + h_buyer_id +
                '}';
    }
}
