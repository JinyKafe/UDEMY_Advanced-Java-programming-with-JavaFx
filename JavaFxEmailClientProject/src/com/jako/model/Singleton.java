package com.jako.model;

/**
 * Created by JaKotek on 20.12.2016.
 */
public class Singleton
{

    private static Singleton instance = new Singleton();

    private EmailMessageBean messageBean;

    private Singleton()
    {
    }

    public EmailMessageBean getMessageBean()
    {
        return messageBean;
    }

    public void setMessageBean(EmailMessageBean messageBean)
    {
        this.messageBean = messageBean;
    }

    public static Singleton getInstance()
    {
        return instance;
    }
}
