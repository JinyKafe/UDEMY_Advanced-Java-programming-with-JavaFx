package com.jako.model.table;

import javafx.scene.control.TableRow;

/**
 * Created by JaKotek on 05.01.2017.
 */
public class BoldableRowFactory<T extends AbstractTableItem> extends TableRow<T>
{

    @Override
    protected void updateItem(T item, boolean empty)
    {
        super.updateItem(item, empty);
        if (item != null && !item.isRead())
        {
            setStyle("-fx-font-weight: bold");
        }
        else
        {
            setStyle("");
        }
    }
}
