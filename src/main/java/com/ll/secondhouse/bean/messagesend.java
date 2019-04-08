package com.ll.secondhouse.bean;

public class messagesend {
    private int ms_id;
    private int ms_senderid;
    private int ms_rid;
    private String ms_content;
    private String ms_date;

    public messagesend(int ms_id, int ms_senderid, int ms_rid, String ms_content, String ms_date) {
        this.ms_id = ms_id;
        this.ms_senderid = ms_senderid;
        this.ms_rid = ms_rid;
        this.ms_content = ms_content;
        this.ms_date = ms_date;
    }

    public int getMs_id() {
        return ms_id;
    }

    public void setMs_id(int ms_id) {
        this.ms_id = ms_id;
    }

    public int getMs_senderid() {
        return ms_senderid;
    }

    public void setMs_senderid(int ms_senderid) {
        this.ms_senderid = ms_senderid;
    }

    public int getMs_rid() {
        return ms_rid;
    }

    public void setMs_rid(int ms_rid) {
        this.ms_rid = ms_rid;
    }

    public String getMs_content() {
        return ms_content;
    }

    public void setMs_content(String ms_content) {
        this.ms_content = ms_content;
    }

    public String getMs_date() {
        return ms_date;
    }

    public void setMs_date(String ms_date) {
        this.ms_date = ms_date;
    }
}
