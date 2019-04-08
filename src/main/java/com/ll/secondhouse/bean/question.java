package com.ll.secondhouse.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Administrator on 2018/12/2/002.
 */
@XmlRootElement(name = "question")
public class question
{
    private int q_id;
    private int q_user_id;
    private int q_house_id;
    private String q_context;

    public int getQ_id()
    {
        return q_id;
    }

    public void setQ_id(int q_id)
    {
        this.q_id = q_id;
    }

    public int getQ_house_id()
    {
        return q_house_id;
    }

    public void setQ_house_id(int q_house_id)
    {
        this.q_house_id = q_house_id;
    }

    public String getQ_context()
    {
        return q_context;
    }

    public void setQ_context(String q_context)
    {
        this.q_context = q_context;
    }

    public int getQ_user_id()
    {
        return q_user_id;
    }

    public void setQ_user_id(int q_user_id)
    {
        this.q_user_id = q_user_id;
    }

    @Override
    public String toString()
    {
        return "question{" +
                "q_id=" + q_id +
                ", q_house_id=" + q_house_id +
                ", q_user_id=" + q_user_id +
                ", q_context='" + q_context + '\'' +
                '}';
    }
}
