package com.jako;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

/**
 * Created by JaKotek on 12.12.2016.
 */
public class MainController implements Initializable
{

    @FXML
    private TreeView<String> emailFoldersTreeView;

    private TreeItem<String> root        = new TreeItem<>();

    private SampleData       sampleData  = new SampleData();

    private MenuItem         showDetails = new MenuItem("show details...");

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

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        senderColumn.setCellValueFactory(new PropertyValueFactory<>("sender"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        //
        sizeColumn.setComparator(Comparator.comparing((String sizeLabel) -> EmailMessageBean.formattedValues.get(sizeLabel)));
        //
        emailFoldersTreeView.setRoot(root);
        root.setValue("example@yahoo.com");
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
        root.setExpanded(true);
        //
        emailTableView.setContextMenu(new ContextMenu(showDetails));
        //
        emailFoldersTreeView.setOnMouseClicked((MouseEvent event) ->
        {
            TreeItem<String> item = emailFoldersTreeView.getSelectionModel().getSelectedItem();
            if (item != null)
            {
                emailTableView.setItems(sampleData.emailFolders.get(item.getValue()));
            }
        });
        emailTableView.setOnMouseClicked((MouseEvent event) ->
        {
            final EmailMessageBean selectedItem = emailTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null)
            {
                messageRenderer.getEngine().loadContent(selectedItem.getContent());
            }
        });
        //
        showDetails.setOnAction((ActionEvent event) -> System.out.println("menu item clicked!!"));
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
