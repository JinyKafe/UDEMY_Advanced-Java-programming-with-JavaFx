package com.jako;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by JaKotek on 14.12.2016.
 */
public class EmailMessageBean
{

    private SimpleStringProperty  sender;

    private SimpleStringProperty  subject;

    private SimpleIntegerProperty size;

    public EmailMessageBean(String sender, String subject, int size)
    {
        this.sender = new SimpleStringProperty(sender);
        this.subject = new SimpleStringProperty(subject);
        this.size = new SimpleIntegerProperty(size);
    }

    public String getSender()
    {
        return sender.get();
    }

    public String getSubject()
    {
        return subject.get();
    }

    public int getSize()
    {
        return size.get();
    }
}
