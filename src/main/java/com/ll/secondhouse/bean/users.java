package com.ll.secondhouse.bean;

public class users {
    private int u_id;
    private String u_username;
    private String u_password;
    private String u_email;
    private String u_data;
    private String u_address;


    public users(int u_id, String u_username, String u_password, String u_email, String u_data, String u_address) {
        this.u_id = u_id;
        this.u_username = u_username;
        this.u_password = u_password;
        this.u_email = u_email;
        this.u_data = u_data;
        this.u_address = u_address;
    }
//  I commented out the code.
    //Then it's useful. Maybe you've released the modified code for error1.
//    public users(){
//
//    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_username() {
        return u_username;
    }

    public void setU_username(String u_username) {
        this.u_username = u_username;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_data() {
        return u_data;
    }

    public void setU_data(String u_data) {
        this.u_data = u_data;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }
    @Override
    public String toString() {
        return "users{" +
                "u_id=" + u_id +
                ", u_username='" + u_username + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_email='" + u_email + '\'' +
                ", u_data='" + u_data + '\'' +
                ", u_address='" + u_address + '\'' +
                '}';
    }
}