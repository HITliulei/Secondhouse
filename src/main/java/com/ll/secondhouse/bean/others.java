package com.ll.secondhouse.bean;

public class others {

    private String produce;
    private String net;

    public others(String produce, String net) {
        this.produce = produce;
        this.net = net;
    }

    @Override
    public String toString() {
        return "others{" +
                "produce='" + produce + '\'' +
                ", net='" + net + '\'' +
                '}';
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }
}
