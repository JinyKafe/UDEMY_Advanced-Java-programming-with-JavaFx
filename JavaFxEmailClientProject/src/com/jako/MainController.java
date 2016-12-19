package com.jako;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

/**
 * Created by JaKotek on 12.12.2016.
 */
public class MainController implements Initializable
{

    @FXML
    private TreeView<String> emailFoldersTreeView;

    private TreeItem<String> root = new TreeItem<>();

    @FXML
    public  TableView<EmailMessageBean>           emailTableView;

    @FXML
    private WebView                               messageRenderer;

    @FXML
    private Button                                Button1;

    @FXML
    private TableColumn<EmailMessageBean, String> sizeColumn;

    @FXML
    private TableColumn<EmailMessageBean, String> senderColumn;

    @FXML
    private TableColumn<EmailMessageBean, String> subjectColumn;

    @FXML
    void Button1Action(ActionEvent event)
    {
        System.out.println("button1 clicked");
    }

    final ObservableList<EmailMessageBean> data = FXCollections.observableArrayList(
            new EmailMessageBean("Nákup na dnešek", "mkotkova@atlas.cz", 4000),
            new EmailMessageBean("Pozdrav z Ceske Lipy", "tomas.radonsky@seznam.cz", 5000),
            new EmailMessageBean("Vyhra v loterii", "bigwin@google.com", 5500000),
            new EmailMessageBean("Vse nejlepsi k Vanocum", "rudolf.kotek@seznam.cz", 50)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        messageRenderer.getEngine().loadContent(
                "<html>Lorem Ipsum je demonstrativní výplňový text používaný v tiskařském a knihařském průmyslu. Lorem Ipsum je považováno za standard v této oblasti už od začátku 16. století, kdy dnes neznámý tiskař vzal kusy textu a na jejich základě vytvořil speciální vzorovou knihu. Jeho odkaz nevydržel pouze pět století, on přežil i nástup elektronické sazby v podstatě beze změny. Nejvíce popularizováno bylo Lorem Ipsum v šedesátých letech 20. století, kdy byly vydávány speciální vzorníky s jeho pasážemi a později pak díky počítačovým DTP programům jako Aldus PageMaker.</html>");
        //
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        senderColumn.setCellValueFactory(new PropertyValueFactory<>("sender"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        //
        emailTableView.setItems(data);
        //
        sizeColumn.setComparator(Comparator.comparing((String sizeLabel) -> EmailMessageBean.formattedValues.get(sizeLabel)));
        //
        emailFoldersTreeView.setRoot(root);
        root.setValue("example@yahoo.com");
        {
            final TreeItem<String> inbox = new TreeItem<>("Inbox", resolveIcon("Inbox"));
            final TreeItem<String> sent = new TreeItem<>("Sent", resolveIcon("Sent"));
            {
                final TreeItem<String> subtitel1 = new TreeItem<>("Subtitel1");
                final TreeItem<String> subtitel2 = new TreeItem<>("Subtitel2");
                sent.getChildren().addAll(subtitel1, subtitel2);
            }
            final TreeItem<String> spam = new TreeItem<>("Spam", resolveIcon("Spam"));
            final TreeItem<String> trash = new TreeItem<>("Trash", resolveIcon("Trash"));
            root.getChildren().addAll(inbox, sent, spam, trash);
        }
        root.setExpanded(true);
    }

    private Node resolveIcon(String treeItemValue)
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
