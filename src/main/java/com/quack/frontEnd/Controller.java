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
    private AnchorPane menuBar;

    @FXML
    private Group menuCreateButton;

    @FXML
    private AnchorPane createCasePanel;

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField ageInput;

    @FXML
    private TextField phoneNumberInput;

    @FXML
    private TextField munipicipalityInput;

    @FXML
    private TextField addressInput;

    @FXML
    private TextField streetInput;

    @FXML
    private TextField zipCodeInput;

    @FXML
    private TextField contactsInput;

    @FXML
    private TextField diagnosisInput;

    @FXML
    private TextField recoveryInput;

    @FXML
    private TextField deathInput;

    @FXML
    private AnchorPane toolBar;

    @FXML
    private ImageView menuButton;

    @FXML
    private Button submitCaseButton;

    @FXML
    public void menuCreateClick(MouseEvent event) {
        if (createCaseHide == true) {
            createCasePanel.setVisible(true);
            createCaseHide = false;
        } else {
            createCasePanel.setVisible(false);
            createCaseHide = true;
        }
    }

    @FXML
    public void menuClick(MouseEvent event) {
        if (menuIsHide == true) {
            menuBar.setVisible(true);
            menuIsHide = false;
        } else {
            menuBar.setVisible(false);
            menuIsHide = true;
        }
    }

    @FXML
    public void submitCaseClick(MouseEvent event) {
        String fn = null;
        String ln = null;
        String pn = null;
        String ad = null;
        String st = null;
        String zc = null;
        String dd = null;
        String rd = null;
        String dt = null;
        int ag = 0;
        int cn = 0;
        int mun = 0;
        if (!firstNameInput.getText().isEmpty()) {
            fn = firstNameInput.getText();
            System.out.println("Empty");
        }
        if (!lastNameInput.getText().isEmpty()) {
            ln = lastNameInput.getText();
            System.out.println("Empty");
        }
        if (!ageInput.getText().isEmpty()) {
            ag = Integer.parseInt(ageInput.getText());
            System.out.println("Empty");
        }
        if (!phoneNumberInput.getText().isEmpty()) {
            pn = phoneNumberInput.getText();
            System.out.println("Empty");
        }
        if (!addressInput.getText().isEmpty()) {
            ad = addressInput.getText();
            System.out.println("Empty");
        }
        if (!streetInput.getText().isEmpty()) {
            st = streetInput.getText();
            System.out.println("Empty");
        }
        if (!zipCodeInput.getText().isEmpty()) {
            zc = zipCodeInput.getText();
            System.out.println("Empty");
        }
        if (!contactsInput.getText().isEmpty()) {
            cn = Integer.parseInt(contactsInput.getText());
            System.out.println("Empty");
        }
        if (!munipicipalityInput.getText().isEmpty()) {
            mun = Integer.parseInt(munipicipalityInput.getText());
            System.out.println("Empty");
        }
        if (!diagnosisInput.getText().isEmpty()) {
            dd = diagnosisInput.getText();
            System.out.println("Empty");
        }
        if (!recoveryInput.getText().isEmpty()) {
            rd = recoveryInput.getText();
            System.out.println("Empty");
        }
        if (!deathInput.getText().isEmpty()) {
            dt = deathInput.getText();
            System.out.println("Empty");
        }

        if ((recoveryInput.getText().isEmpty()) && (deathInput.getText().isEmpty())) {
            Case activeCase = new Case(dd, cn, fn, ln, ag, pn, mun, ad, st, zc);
            CaseDAO caseDAO = new CaseDAO();
            try {
                caseDAO.createCaseActive(activeCase);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("to krousma ine energo");
        }

        if(!(recoveryInput.getText().isEmpty()) && (deathInput.getText().isEmpty())){
            Case caseRecover = new Case(cn, dd, rd, fn, ln, ag, pn, mun, ad, st, zc);
            CaseDAO caseDAO = new CaseDAO();
            try {
                caseDAO.createCaseRecovery(caseRecover);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("to krousma anarose!!");
        }

        if ((recoveryInput.getText().isEmpty()) && !(deathInput.getText().isEmpty())){
            Case caseDead = new Case(dd, dt, cn, fn, ln, ag, pn, mun, ad, st, zc);
            CaseDAO caseDAO = new CaseDAO();
            try {
                caseDAO.createCaseDead(caseDead);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("to krousma petane");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}

