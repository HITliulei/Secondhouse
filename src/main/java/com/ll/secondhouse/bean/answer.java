package com.ll.secondhouse.bean;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "answer")
public class answer
{
    private int a_id;
    private String a_context;
    private int a_question_id;
    private int a_house_id;
    private int a_user_id;

    public int getA_id()
    {
        return a_id;
    }

    public void setA_id(int a_id)
    {
        this.a_id = a_id;
    }

    public String getA_context()
    {
        return a_context;
    }

    public void setA_context(String a_context)
    {
        this.a_context = a_context;
    }

    public int getA_question_id()
    {
        return a_question_id;
    }

    public void setA_question_id(int a_question_id)
    {
        this.a_question_id = a_question_id;
    }

    public int getA_house_id()
    {
        return a_house_id;
    }

    public void setA_house_id(int a_house_id)
    {
        this.a_house_id = a_house_id;
    }

    public int getA_user_id()
    {
        return a_user_id;
    }

    public void setA_user_id(int a_user_id)
    {
        this.a_user_id = a_user_id;
    }

    @Override
    public String toString()
    {
        return "answer{" +
                "a_id=" + a_id +
                ", a_context='" + a_context + '\'' +
                ", a_question_id=" + a_question_id +
                ", a_house_id=" + a_house_id +
                ", a_user_id=" + a_user_id +
                '}';
    }
}
