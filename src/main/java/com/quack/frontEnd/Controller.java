package com.quack.frontEnd;

import com.quack.backEnd.Case;
import com.quack.db.CaseDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private boolean menuIsHide = true;
    private boolean createCaseHide = true;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane toolBar;

    @FXML
    private ImageView menuButton;

    @FXML
    private AnchorPane menuBar;

    @FXML
    private Group create;

    @FXML
    private AnchorPane createCasePanel;


    @FXML
    public void menuClick(MouseEvent event) {
        if(menuIsHide == true){
            menuBar.setVisible(true);
            menuIsHide = false;
        }else{
            menuBar.setVisible(false);
            menuIsHide = true;
        }


    }

    @FXML
    public void createCaseClick(MouseEvent event) {
        if(createCaseHide == true){
            createCasePanel.setVisible(true);
            createCaseHide = false;
        }else{
            createCasePanel.setVisible(false);
            createCaseHide = true;
        }

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


}

