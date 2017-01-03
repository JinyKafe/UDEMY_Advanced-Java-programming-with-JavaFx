package com.jako.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.OperationNotSupportedException;

import com.jako.model.EmailMessageBean;
import com.jako.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Created by JaKotek on 20.12.2016.
 */
public class EmailDetailController extends AbstractController implements Initializable
{

    private ModelAccess modelAccess;

    @FXML
    void IllegalOperationAction() throws OperationNotSupportedException
    {
        ViewFactory viewFactory = new ViewFactory();
        Scene scene = viewFactory.getMainScene();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Label   senderLabel;

    @FXML
    private WebView webView;

    @FXML
    private Label   subjectLabel;

    public EmailDetailController(ModelAccess modelAccess)
    {
        super(modelAccess);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        EmailMessageBean selectedMessage = getModelAccess().getSelectedMessage();
        System.out.println("EmailDetailController intitialized");
        subjectLabel.setText("Subject: " + selectedMessage.getSubject());
        senderLabel.setText("Sender: " + selectedMessage.getSender());
        webView.getEngine().loadContent(selectedMessage.getContent());
    }
}
