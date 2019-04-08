package com.ll.secondhouse.bean;

public class messagerecieved {
    private int mr_id;
    private int mr_sid;
    private int mr_recieveid;
    private String mr_content;
    private String mr_date;

    public messagerecieved(int mr_id, int mr_sid, int mr_recieveid, String mr_content, String mr_date) {
        this.mr_id = mr_id;
        this.mr_sid = mr_sid;
        this.mr_recieveid = mr_recieveid;
        this.mr_content = mr_content;
        this.mr_date = mr_date;
    }

    public int getMr_id() {
        return mr_id;
    }

    public void setMr_id(int mr_id) {
        this.mr_id = mr_id;
    }

    public int getMr_sid() {
        return mr_sid;
    }

    public void setMr_sid(int mr_sid) {
        this.mr_sid = mr_sid;
    }

    public int getMr_recieveid() {
        return mr_recieveid;
    }

    public void setMr_recieveid(int mr_recieveid) {
        this.mr_recieveid = mr_recieveid;
    }

    public String getMr_content() {
        return mr_content;
    }

    public void setMr_content(String mr_content) {
        this.mr_content = mr_content;
    }

    public String getMr_date() {
        return mr_date;
    }

    public void setMr_date(String mr_date) {
        this.mr_date = mr_date;
    }

    @Override
    public String toString() {
        return "messagerecieved{" +
                "mr_id=" + mr_id +
                ", mr_sid=" + mr_sid +
                ", mr_recieveid=" + mr_recieveid +
                ", mr_content='" + mr_content + '\'' +
                ", mr_date='" + mr_date + '\'' +
                '}';
    }
}