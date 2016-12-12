package com.jako;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * Created by JaKotek on 12.12.2016.
 */
public class MainController implements Initializable
{

    @FXML
    private Button Button1;

    @FXML
    void Button1Action(ActionEvent event)
    {
        System.out.println("button1 clicked");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println("Document loaded!");
    }
}
