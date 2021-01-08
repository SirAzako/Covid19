package com.quack.frontEnd;

import com.quack.backEnd.Case;
import com.quack.backEnd.Contact;
import com.quack.db.CaseDAO;

import com.quack.db.ContactDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private boolean menuIsHide = true;
    private boolean createCaseHide = true;
    private boolean addContactsHide = true;
    private boolean addContactUniqueHide = true;
    private int totalContacts = 0;
    private int counterContacts = 1;
    private int parseAFM = 0;


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane addContactUniquePanel;

    @FXML
    private AnchorPane menuBar;

    @FXML
    private AnchorPane addContactsPanel;

    @FXML
    private Group menuCreateButton;

    @FXML
    private Group menuContactButton;

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
    private TextField afmInput;

    @FXML
    private TextField firstNameCQInput;

    @FXML
    private TextField lastNameCQInput;

    @FXML
    private TextField ageCQInput;

    @FXML
    private TextField phoneNumberCQInput;

    @FXML
    private TextField munipicipalityCQInput;

    @FXML
    private TextField addressCQInput;

    @FXML
    private TextField streetCQInput;

    @FXML
    private TextField zipCQCodeInput;

    @FXML
    private TextField afmCQInput;

    @FXML
    private TextField afmCQKrousmatosInput;


    @FXML
    private DatePicker diagnosisInput;

    @FXML
    private DatePicker recoveryInput;

    @FXML
    private DatePicker deathInput;

    @FXML
    private TextField firstNameCInput;

    @FXML
    private TextField lastNameCInput;

    @FXML
    private TextField ageCInput;

    @FXML
    private TextField phoneNumberCInput;

    @FXML
    private TextField munipicipalityCInput;

    @FXML
    private TextField addressCInput;

    @FXML
    private TextField streetCInput;

    @FXML
    private TextField zipCCodeInput;

    @FXML
    private TextField afmCInput;

    @FXML
    private AnchorPane toolBar;

    @FXML
    private ImageView menuButton;

    @FXML
    private Button submitCaseButton;

    @FXML
    private Button submitContactButton;

    @FXML
    private Button submitContactUniqueButton;

    @FXML
    private Label numberLabel;


    @FXML
    private Label counterLabel;


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
        int af = 0;
        int ag = 0;
        int cn = 0;
        int mun = 0;
        if (!firstNameInput.getText().isEmpty()) {
            fn = firstNameInput.getText();
        }
        if (!lastNameInput.getText().isEmpty()) {
            ln = lastNameInput.getText();
        }
        if (!ageInput.getText().isEmpty()) {
            ag = Integer.parseInt(ageInput.getText());
        }
        if (!phoneNumberInput.getText().isEmpty()) {
            pn = phoneNumberInput.getText();
        }
        if (!addressInput.getText().isEmpty()) {
            ad = addressInput.getText();
        }
        if (!streetInput.getText().isEmpty()) {
            st = streetInput.getText();
        }
        if (!zipCodeInput.getText().isEmpty()) {
            zc = zipCodeInput.getText();
        }
        if (!contactsInput.getText().isEmpty()) {
            cn = Integer.parseInt(contactsInput.getText());
        }
        if (!munipicipalityInput.getText().isEmpty()) {
            mun = Integer.parseInt(munipicipalityInput.getText());
        }
        if (!(diagnosisInput.getValue() == null)) {
            dd = String.valueOf(diagnosisInput.getValue());
            System.out.println(dd);
        }
        if (!(recoveryInput.getValue() == null)) {
            rd = String.valueOf(recoveryInput.getValue());
        }
        if (!(deathInput.getValue() == null)) {
            dt = String.valueOf(deathInput.getValue());
        }
        if (!afmInput.getText().isEmpty()) {
            af = Integer.parseInt(afmInput.getText());
        }

        if (((recoveryInput.getValue() == null)) && ((deathInput.getValue() == null))) {
            parseAFM = af;
            Case krousma = new Case(dd, cn, af, fn, ln, ag, pn, mun, ad,
                    st, zc);
            CaseDAO caseDAO = new CaseDAO();
            try {
                caseDAO.createCaseActive(krousma);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Case created successfully..");
                System.out.println("The case is active..");

                totalContacts = cn;
                numberLabel.setText(String.valueOf(totalContacts));
                counterLabel.setText(String.valueOf(counterContacts));

                firstNameInput.clear();
                lastNameInput.clear();
                ageInput.clear();
                phoneNumberInput.clear();
                addressInput.clear();
                streetInput.clear();
                zipCodeInput.clear();
                contactsInput.clear();
                munipicipalityInput.clear();
                diagnosisInput.getEditor().clear();
                deathInput.getEditor().clear();
                recoveryInput.getEditor().clear();
                afmInput.clear();

                if (addContactsHide == true) {
                    addContactsPanel.setVisible(true);
                    addContactsHide = false;
                }
                if (createCaseHide == false) {
                    createCasePanel.setVisible(false);
                    createCaseHide = true;
                }
            }
        }

        if (!(recoveryInput.getValue() == null) && (deathInput.getValue() == null)) {
            parseAFM = af;
            Case krousma = new Case(cn, dd, rd, af, fn, ln, ag, pn, mun,
                    ad, st, zc);
            CaseDAO caseDAO = new CaseDAO();
            try {
                caseDAO.createCaseRecovery(krousma);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Case created successfully..");
                System.out.println("The case is recovery..");

                totalContacts = cn;
                numberLabel.setText(String.valueOf(totalContacts));
                counterLabel.setText(String.valueOf(counterContacts));

                firstNameInput.clear();
                lastNameInput.clear();
                ageInput.clear();
                phoneNumberInput.clear();
                addressInput.clear();
                streetInput.clear();
                zipCodeInput.clear();
                contactsInput.clear();
                munipicipalityInput.clear();
                diagnosisInput.getEditor().clear();
                deathInput.getEditor().clear();
                recoveryInput.getEditor().clear();
                afmInput.clear();

                if (addContactsHide == true) {
                    addContactsPanel.setVisible(true);
                    addContactsHide = false;
                }
                if (createCaseHide == false) {
                    createCasePanel.setVisible(false);
                    createCaseHide = true;
                }
            }

        }

        if ((recoveryInput.getValue() == null) && !(deathInput.getValue() == null)) {
            parseAFM = af;
            Case krousma = new Case(dd, dt, cn, af, fn, ln, ag, pn, mun, ad,
                    st, zc);
            CaseDAO caseDAO = new CaseDAO();
            try {
                caseDAO.createCaseDead(krousma);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Case created successfully..");
                System.out.println("The case is dead..");

                totalContacts = cn;
                numberLabel.setText(String.valueOf(totalContacts));
                counterLabel.setText(String.valueOf(counterContacts));

                firstNameInput.clear();
                lastNameInput.clear();
                ageInput.clear();
                phoneNumberInput.clear();
                addressInput.clear();
                streetInput.clear();
                zipCodeInput.clear();
                contactsInput.clear();
                munipicipalityInput.clear();
                diagnosisInput.getEditor().clear();
                deathInput.getEditor().clear();
                recoveryInput.getEditor().clear();
                afmInput.clear();

                counterContacts = 1;

                if (addContactsHide == true) {
                    addContactsPanel.setVisible(true);
                    addContactsHide = false;
                }
                if (createCaseHide == false) {
                    createCasePanel.setVisible(false);
                    createCaseHide = true;
                }
            }

        }

    }


    @FXML
    public void submitContactClick(MouseEvent event) {
        String fnC = null;
        String lnC = null;
        int ageC = 0;
        String pnC = null;
        int munC = 0;
        String addC = null;
        String stC = null;
        String zcC = null;
        int afmC = 0;
        int conID = 0;

        counterContacts++;
        counterLabel.setText(String.valueOf(counterContacts));


        if (!firstNameCInput.getText().isEmpty()) {
            fnC = firstNameCInput.getText();
            System.out.println("gematon name");
        }
        if (!lastNameCInput.getText().isEmpty()) {
            lnC = lastNameCInput.getText();
            System.out.println("gemato lastname");
        }
        if (!ageCInput.getText().isEmpty()) {
            ageC = Integer.parseInt(ageCInput.getText());
            System.out.println("gemati ilikia");
        }
        if (!phoneNumberCInput.getText().isEmpty()) {
            pnC = phoneNumberCInput.getText();
            System.out.println("gemato to number");
        }
        if (!munipicipalityCInput.getText().isEmpty()) {
            munC = Integer.parseInt(munipicipalityCInput.getText());
            System.out.println("gematos o dimos");
        }
        if (!addressCInput.getText().isEmpty()) {
            addC = addressCInput.getText();
            System.out.println("addres ok");
        }
        if (!streetCInput.getText().isEmpty()) {
            stC = streetCInput.getText();
            System.out.println("street ok");
        }
        if (!zipCCodeInput.getText().isEmpty()) {
            zcC = zipCCodeInput.getText();
            System.out.println("zip ok");
        }
        if (!afmCInput.getText().isEmpty()) {
            afmC = Integer.parseInt(afmCInput.getText());
            conID = Integer.parseInt(afmCInput.getText());
            System.out.println("afm ok");
        }
        if ((!firstNameCInput.getText().isEmpty()) && (!lastNameCInput.getText().isEmpty()) && (!ageCInput.getText().isEmpty()) && (!phoneNumberCInput.getText().isEmpty()) && (!munipicipalityCInput.getText().isEmpty()) && (!addressCInput.getText().isEmpty()) && (!streetCInput.getText().isEmpty()) && (!zipCCodeInput.getText().isEmpty()) && (!afmCInput.getText().isEmpty())) {
            System.out.println("antikimeno ok");
            Contact contact = new Contact(afmC, conID, fnC, lnC, ageC, pnC,
                    munC,
                    addC, stC, zcC);
            ContactDAO contactDAO = new ContactDAO();
            try {
                contactDAO.createContact(contact);
                contactDAO.connectCaseContact(parseAFM, contact);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("DIMIOURGITHIKE I EPAFI");
                firstNameCInput.clear();
                lastNameCInput.clear();
                ageCInput.clear();
                phoneNumberCInput.clear();
                munipicipalityCInput.clear();
                addressCInput.clear();
                streetCInput.clear();
                zipCCodeInput.clear();
                afmCInput.clear();
                if (counterContacts > totalContacts) {
                    if (addContactsHide == false) {
                        addContactsPanel.setVisible(false);
                        addContactsHide = true;
                    }
                }
            }
        }

    }

    @FXML
    public void menuAddContactClick(MouseEvent event) {
        if(addContactUniqueHide == true){
            addContactUniquePanel.setVisible(true);
            addContactUniqueHide = false;
        }else{
            addContactUniquePanel.setVisible(false);
            addContactUniqueHide = true;
        }
    }

    @FXML
    public void submitContactUniqueClick(MouseEvent event) {
        String fnC = null;
        String lnC = null;
        int ageC = 0;
        String pnC = null;
        int munC = 0;
        String addC = null;
        String stC = null;
        String zcC = null;
        int afmC = 0;
        int conID = 0;
        int afmK = 0;


        if (!firstNameCQInput.getText().isEmpty()) {
            fnC = firstNameCQInput.getText();
            System.out.println("gematon name");
        }
        if (!lastNameCQInput.getText().isEmpty()) {
            lnC = lastNameCQInput.getText();
            System.out.println("gemato lastname");
        }
        if (!ageCQInput.getText().isEmpty()) {
            ageC = Integer.parseInt(ageCQInput.getText());
            System.out.println("gemati ilikia");
        }
        if (!phoneNumberCQInput.getText().isEmpty()) {
            pnC = phoneNumberCQInput.getText();
            System.out.println("gemato to number");
        }
        if (!munipicipalityCQInput.getText().isEmpty()) {
            munC = Integer.parseInt(munipicipalityCQInput.getText());
            System.out.println("gematos o dimos");
        }
        if (!addressCQInput.getText().isEmpty()) {
            addC = addressCQInput.getText();
            System.out.println("addres ok");
        }
        if (!streetCQInput.getText().isEmpty()) {
            stC = streetCQInput.getText();
            System.out.println("street ok");
        }
        if (!zipCQCodeInput.getText().isEmpty()) {
            zcC = zipCQCodeInput.getText();
            System.out.println("zip ok");
        }
        if (!afmCQInput.getText().isEmpty()) {
            afmC = Integer.parseInt(afmCQInput.getText());
            System.out.println("afm ok");
        }
        if(!afmCQKrousmatosInput.getText().isEmpty()){
            afmK = Integer.parseInt(afmCQKrousmatosInput.getText());
        }
        if ((!firstNameCQInput.getText().isEmpty()) && (!lastNameCQInput.getText().isEmpty()) && (!ageCQInput.getText().isEmpty()) && (!phoneNumberCQInput.getText().isEmpty()) && (!munipicipalityCQInput.getText().isEmpty()) && (!addressCQInput.getText().isEmpty()) && (!streetCQInput.getText().isEmpty()) && (!zipCQCodeInput.getText().isEmpty()) && (!afmCQInput.getText().isEmpty()) && (!afmCQKrousmatosInput.getText().isEmpty())) {
            System.out.println("antikimeno ok");
            Contact contact = new Contact(afmC, afmC, fnC, lnC, ageC, pnC,
                    munC,
                    addC, stC, zcC);
            ContactDAO contactDAO = new ContactDAO();
            try {
                contactDAO.createContact(contact);
                contactDAO.connectCaseContact(afmK, contact);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("DIMIOURGITHIKE I EPAFI");
                firstNameCQInput.clear();
                lastNameCQInput.clear();
                ageCQInput.clear();
                phoneNumberCQInput.clear();
                munipicipalityCQInput.clear();
                addressCQInput.clear();
                streetCQInput.clear();
                zipCQCodeInput.clear();
                afmCQInput.clear();
                afmCQKrousmatosInput.clear();

                if (addContactUniqueHide == false) {
                    addContactUniquePanel.setVisible(false);
                    addContactUniqueHide = true;

                }
            }
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


}

