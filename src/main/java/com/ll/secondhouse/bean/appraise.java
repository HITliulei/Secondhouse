package com.ll.secondhouse.bean;

public class appraise {
    private int a_id;
    private String a_content;
    private int a_userid;
    private int a_house;
    private String a_data;

    public appraise(int a_id, String a_content, int a_userid, int a_house, String a_data) {
        this.a_id = a_id;
        this.a_content = a_content;
        this.a_userid = a_userid;
        this.a_house = a_house;
        this.a_data = a_data;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_content() {
        return a_content;
    }

    public void setA_content(String a_content) {
        this.a_content = a_content;
    }

    public int getA_userid() {
        return a_userid;
    }

    public void setA_userid(int a_userid) {
        this.a_userid = a_userid;
    }

    public int getA_house() {
        return a_house;
    }

    public void setA_house(int a_house) {
        this.a_house = a_house;
    }

    public String getA_data() {
        return a_data;
    }

    public void setA_data(String a_data) {
        this.a_data = a_data;
    }

    @Override
    public String toString() {
        return "appraise{" +
                "a_id=" + a_id +
                ", a_content='" + a_content + '\'' +
                ", a_userid=" + a_userid +
                ", a_house=" + a_house +
                ", a_data='" + a_data + '\'' +
                '}';
    }
}
