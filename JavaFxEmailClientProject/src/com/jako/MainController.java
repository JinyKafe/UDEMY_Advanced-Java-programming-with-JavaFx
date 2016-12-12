package com.jako;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;

/**
 * Created by JaKotek on 12.12.2016.
 */
public class MainController implements Initializable
{
    @FXML
    private WebView messageRenderer;

    @FXML
    private Button  Button1;

    @FXML
    void Button1Action(ActionEvent event)
    {
        System.out.println("button1 clicked");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
       messageRenderer.getEngine().loadContent("<html>Lorem Ipsum je demonstrativní výplňový text používaný v tiskařském a knihařském průmyslu. Lorem Ipsum je považováno za standard v této oblasti už od začátku 16. století, kdy dnes neznámý tiskař vzal kusy textu a na jejich základě vytvořil speciální vzorovou knihu. Jeho odkaz nevydržel pouze pět století, on přežil i nástup elektronické sazby v podstatě beze změny. Nejvíce popularizováno bylo Lorem Ipsum v šedesátých letech 20. století, kdy byly vydávány speciální vzorníky s jeho pasážemi a později pak díky počítačovým DTP programům jako Aldus PageMaker.</html>");
    }
}
