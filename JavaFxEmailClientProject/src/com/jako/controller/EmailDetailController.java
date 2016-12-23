package com.jako.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jako.model.Singleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

/**
 * Created by JaKotek on 20.12.2016.
 */
public class EmailDetailController implements Initializable
{

    @FXML
    private Label     senderLabel;

    @FXML
    private WebView   webView;

    @FXML
    private Label     subjectLabel;

    private Singleton singleton;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        singleton = Singleton.getInstance();
        System.out.println("EmailDetailController intitialized");
        subjectLabel.setText("Subject: " + singleton.getMessageBean().getSubject());
        senderLabel.setText("Sender: " + singleton.getMessageBean().getSender());
        webView.getEngine().loadContent(singleton.getMessageBean().getContent());
    }
}
