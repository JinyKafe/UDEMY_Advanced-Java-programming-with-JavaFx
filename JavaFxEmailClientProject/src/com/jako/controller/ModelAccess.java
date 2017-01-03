package com.jako.controller;

import com.jako.model.EmailMessageBean;

/**
 * Created by JaKotek on 03.01.2017.
 */
public class ModelAccess
{

    private EmailMessageBean selectedMessage;

    public EmailMessageBean getSelectedMessage()
    {
        return selectedMessage;
    }

    public void setSelectedMessage(EmailMessageBean selectedMessage)
    {
        this.selectedMessage = selectedMessage;
    }
}
