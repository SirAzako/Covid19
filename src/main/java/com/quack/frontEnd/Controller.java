package com.quack.frontEnd;

import com.quack.backEnd.Case;
import com.quack.db.CaseDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button submit;

    @FXML
    private TextField firstNameIn;

    @FXML
    private TextField lastNameIn;

    @FXML
    private TextField ageIn;

    @FXML
    private TextField phoneNumberIn;

    @FXML
    private TextField diagnosisIn;

    @FXML
    private TextField addressIn;

    @FXML
    private TextField streetNumberIn;

    @FXML
    private TextField zipCodeIn;

    @FXML
    private TextField dimosIDIn;

    @FXML
    private TextField contactsNumberIn;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void clicked(ActionEvent event) {
        String fn = firstNameIn.getText();
        String ln = lastNameIn.getText();
        int ag = Integer.parseInt(ageIn.getText());
        String pn = phoneNumberIn.getText();
        String d = diagnosisIn.getText();
        String add = addressIn.getText();
        String sn = streetNumberIn.getText();
        String zc = zipCodeIn.getText();
        int cn = Integer.parseInt(contactsNumberIn.getText());
        int dimos = Integer.parseInt(dimosIDIn.getText());

        System.out.println("Hello");
        Case aCase = new Case(d, cn, fn, ln, ag, pn, dimos, add, sn, zc);
        CaseDAO caseDAO = new CaseDAO();
        try {
            caseDAO.createCase(aCase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

