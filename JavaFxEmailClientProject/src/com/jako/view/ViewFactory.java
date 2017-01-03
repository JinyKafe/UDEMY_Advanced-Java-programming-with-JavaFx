package com.jako.view;

import java.io.IOException;

import com.jako.controller.AbstractController;
import com.jako.controller.EmailDetailController;
import com.jako.controller.MainController;
import com.jako.controller.ModelAccess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by JaKotek on 23.12.2016.
 */
public class ViewFactory
{

    public static final String      DEFAULT_CSS               = "style.css";

    public static final String      MAIN_LAYOUT_FXML          = "MainLayout.fxml";

    public static final String      EMAIL_DETAILS_LAYOUT_FXML = "EmailDetailsLayout.fxml";

    private             ModelAccess modelAccess               = new ModelAccess();

    private MainController        mainController;

    private EmailDetailController emailDetailController;

    public Scene getMainScene()
    {
        mainController = new MainController(modelAccess);
        return initializeScene(MAIN_LAYOUT_FXML, mainController);
    }

    public Scene getEmailDetailsScene()
    {
        emailDetailController = new EmailDetailController(modelAccess);
        return initializeScene(EMAIL_DETAILS_LAYOUT_FXML, mainController);
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

    private Scene initializeScene(String fxmlPath, AbstractController abstractController)
    {
        FXMLLoader loader;
        Parent parent;
        Scene scene;
        loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setController(abstractController);
        try
        {
            parent = loader.load();
        }
        catch (IOException e)
        {
            return null;
        }
        scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource(DEFAULT_CSS).toExternalForm());
        return scene;
    }
}
