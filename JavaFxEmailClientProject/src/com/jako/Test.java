package com.jako;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by JaKotek on 12.12.2016.
 */
public class Test extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Pane parent = new FlowPane();
        final Label label = new Label("label!!");
        final Button button = new Button("Click!!");
        parent.getChildren().addAll(label, button);
        //
        button.setOnAction((ActionEvent event) ->
        {
            System.out.println("clicking the button");
            System.out.println(event.getSource());
        });
        //
        final Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        //
        primaryStage.show();
    }
}
