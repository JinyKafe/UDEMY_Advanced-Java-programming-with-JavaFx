package com.jako.model.table;

import javafx.beans.property.SimpleBooleanProperty;

/**
 * Created by JaKotek on 05.01.2017.
 */
public abstract class AbstractTableItem
{

    private final SimpleBooleanProperty read = new SimpleBooleanProperty();

    public AbstractTableItem(boolean isRead)
    {
        setRead(isRead);
    }

    public SimpleBooleanProperty getReagetdProperty()
    {
        return read;
    }

    public boolean isRead()
    {
        return read.get();
    }

    public void setRead(boolean isRead)
    {
        read.set(isRead);
    }
}
