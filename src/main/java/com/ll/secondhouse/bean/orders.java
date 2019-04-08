package com.ll.secondhouse.bean;

public class orders {
    private int o_id;
    private int u_id;
    private int h_id;
    private String date;
    private int o_state;
    private double h_money;


    public orders(int o_id, int u_id, int h_id, String date,int o_state, double h_money) {
        this.o_id = o_id;
        this.u_id = u_id;
        this.h_id = h_id;
        this.date = date;
        this.h_money = h_money;
        this.o_state = o_state;
    }

    @Override
    public String toString() {
        return "orders{" +
                "o_id=" + o_id +
                ", u_id=" + u_id +
                ", h_id=" + h_id +
                ", date='" + date + '\'' +
                ", h_money=" + h_money +
                ", o_state=" + o_state +
                '}';
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getH_money() {
        return h_money;
    }

    public void setH_money(double h_money) {
        this.h_money = h_money;
    }

    public int getO_state() {
        return o_state;
    }

    public void setO_state(int o_state) {
        this.o_state = o_state;
    }
}
