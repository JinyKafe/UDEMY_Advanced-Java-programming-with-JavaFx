package com.jako.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by JaKotek on 23.12.2016.
 */
public class ViewFactory
{

    public Scene getMainScene()
    {
        Pane pane;
        try
        {
            pane = FXMLLoader.load(getClass().getResource("MainLayout.fxml"));
        }
        catch (IOException e)
        {
            pane = null;
        }
        final Scene scene = new Scene(pane);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        return scene;
    }

    public Scene getEmailDetailsScene()
    {
        Pane pane;
        try
        {
            pane = FXMLLoader.load(getClass().getResource("EmailDetailsLayout.fxml"));
        }
        catch (IOException e)
        {
            pane = null;
        }
        final Scene scene = new Scene(pane);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        return scene;
    }

    public Node resolveIcon(String treeItemValue)
    {
        ImageView imageView;
        try
        {
            final String lowerCaseTreeItemValue = treeItemValue.contains("@") ? "email" : treeItemValue.toLowerCase();
            switch (lowerCaseTreeItemValue)
            {
                case "inbox":
                    imageView = new ImageView(new Image(getClass().getResourceAsStream("images/inbox.png")));
                    break;
                case "sent":
                    imageView = new ImageView(new Image(getClass().getResourceAsStream("images/sent2.png")));
                    break;
                case "spam":
                    imageView = new ImageView(new Image(getClass().getResourceAsStream("images/spam.png")));
                    break;
                case "email":
                    imageView = new ImageView(new Image(getClass().getResourceAsStream("images/email.png")));
                    break;
                default:
                    imageView = new ImageView(new Image(getClass().getResourceAsStream("images/folder.png")));
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid image location!!!");
            e.printStackTrace();
            imageView = new ImageView();
        }
        imageView.setFitHeight(16);
        imageView.setFitWidth(16);
        return imageView;
    }
}
