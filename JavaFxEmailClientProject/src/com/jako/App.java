package com.jako;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by JaKotek on 12.12.2016.
 */
public class App extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Pane parent = FXMLLoader.load(getClass().getResource("MainLayout.fxml"));
        //
        final Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        //
        primaryStage.show();
    }
}
