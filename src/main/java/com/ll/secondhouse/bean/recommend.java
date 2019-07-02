package com.ll.secondhouse.bean;

public class recommend {
    private int t_id;
    private int u_id;
    private int h_id;
    private int score;

    public recommend(int t_id, int u_id, int h_id, int score) {
        this.t_id = t_id;
        this.u_id = u_id;
        this.h_id = h_id;
        this.score = score;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "recommend{" +
                "t_id=" + t_id +
                ", u_id=" + u_id +
                ", h_id=" + h_id +
                ", score=" + score +
                '}';
    }
}
