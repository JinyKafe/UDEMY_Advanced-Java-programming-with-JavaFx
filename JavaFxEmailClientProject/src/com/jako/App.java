package com.jako;

import com.jako.view.ViewFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by JaKotek on 12.12.2016.
 */
public class App extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        final ViewFactory viewFactory = new ViewFactory();
        final Scene scene = viewFactory.getMainScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
