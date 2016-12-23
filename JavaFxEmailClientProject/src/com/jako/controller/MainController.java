package com.jako.controller;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import com.jako.model.EmailMessageBean;
import com.jako.model.SampleData;
import com.jako.model.Singleton;
import com.jako.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Created by JaKotek on 12.12.2016.
 */
public class MainController implements Initializable
{

    @FXML
    public  TableView<EmailMessageBean>           emailTableView;

    @FXML
    private TreeView<String> emailFoldersTreeView;

    private TreeItem<String> root        = new TreeItem<>();

    private SampleData       sampleData  = new SampleData();

    private MenuItem         showDetails = new MenuItem("show details...");

    private Singleton                             singleton;

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
        final ViewFactory viewFactory = new ViewFactory();
        singleton = Singleton.getInstance();
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        senderColumn.setCellValueFactory(new PropertyValueFactory<>("sender"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        //
        sizeColumn.setComparator(Comparator.comparing((String sizeLabel) -> EmailMessageBean.formattedValues.get(sizeLabel)));
        //
        emailFoldersTreeView.setRoot(root);
        root.setValue("example@yahoo.com");
        final TreeItem<String> inbox = new TreeItem<>("Inbox", viewFactory.resolveIcon("Inbox"));
        final TreeItem<String> sent = new TreeItem<>("Sent", viewFactory.resolveIcon("Sent"));
        {
            final TreeItem<String> subtitel1 = new TreeItem<>("Subtitel1");
            final TreeItem<String> subtitel2 = new TreeItem<>("Subtitel2");
            sent.getChildren().addAll(subtitel1, subtitel2);
        }
        final TreeItem<String> spam = new TreeItem<>("Spam", viewFactory.resolveIcon("Spam"));
        final TreeItem<String> trash = new TreeItem<>("Trash", viewFactory.resolveIcon("Trash"));
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
                singleton.setMessageBean(selectedItem);
            }
        });
        //
        showDetails.setOnAction((ActionEvent event) ->
        {
            final Stage stage = new Stage();
            final Scene scene = viewFactory.getEmailDetailsScene();
            stage.setScene(scene);
            stage.show();
        });
    }
}
