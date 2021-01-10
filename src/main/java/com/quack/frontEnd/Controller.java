package com.quack.frontEnd;

import com.quack.backEnd.Case;
import com.quack.backEnd.Contact;
import com.quack.db.CaseDAO;

import com.quack.db.ContactDAO;
import com.quack.db.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private boolean menuIsHide = true;
    private boolean createCaseHide = true;
    private boolean addContactsHide = true;
    private boolean addContactUniqueHide = true;
    private boolean findPersonHide = true;
    private int totalContacts = 0;
    private int counterContacts = 1;
    private int parseAFM = 0;
    private int contactsNumberSQL = 0;

    /*  Here we will initialize all the fields, button, datePickers and AnchorPane
     *   that we will need in our use cases
     */

    // Main anchorPane
    @FXML
    private AnchorPane anchorPane;


    // Menu bar items
    @FXML
    private ImageView menuButton;

    @FXML
    private AnchorPane toolBar;

    @FXML
    private AnchorPane menuBar;

    @FXML
    private Group menuCreateButton;

    @FXML
    private Group menuContactButton;

    @FXML
    private Group menuFindPersonButton;


    // Create Case Panel (AnchorPane, Fields, ComboBox, DatePickers, Button)
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
    private ComboBox<String> municipalityInput;

    @FXML
    private DatePicker diagnosisInput;

    @FXML
    private DatePicker recoveryInput;

    @FXML
    private DatePicker deathInput;

    @FXML
    private Button submitCaseButton;


    // Add contacts to the created case (AnchorPane, Fields, Button, Labels)
    @FXML
    private AnchorPane addContactsPanel;

    @FXML
    private Label numberLabel;

    @FXML
    private Label counterLabel;

    @FXML
    private TextField firstNameCInput;

    @FXML
    private TextField lastNameCInput;

    @FXML
    private TextField ageCInput;

    @FXML
    private TextField phoneNumberCInput;

    @FXML
    private ComboBox<String> municipalityCInput;

    @FXML
    private TextField addressCInput;

    @FXML
    private TextField streetCInput;

    @FXML
    private TextField zipCCodeInput;

    @FXML
    private TextField afmCInput;

    @FXML
    private Button submitContactButton;


    // Add a contact to a specific case (AnchorPane, Fields, Button)
    @FXML
    private AnchorPane addContactUniquePanel;

    @FXML
    private TextField firstNameCQInput;

    @FXML
    private TextField lastNameCQInput;

    @FXML
    private TextField ageCQInput;

    @FXML
    private TextField phoneNumberCQInput;

    @FXML
    private ComboBox<String> municipalityCQInput;

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
    private Button submitContactUniqueButton;

    //Find persons (AnchorPane, Fields, Button)
    @FXML
    private AnchorPane findPersonPanel;

    @FXML
    private TableView<Case> personsTable;

    @FXML
    private TableColumn<Case, Integer> afmTable;

    @FXML
    private TableColumn<Case, Integer> numberOfContactsTable;

    @FXML
    private TableColumn<Case, String> firstNameTable;

    @FXML
    private TableColumn<Case, String> lastNameTable;

    @FXML
    private TableColumn<Case, Integer> ageTable;

    @FXML
    private TableColumn<Case, String> phoneNumberTable;

    @FXML
    private TableColumn<Case, Integer> dimosTable;

    @FXML
    private TableColumn<Case, String> addressTable;

    @FXML
    private TableColumn<Case, String> stNumberTable;

    @FXML
    private TableColumn<Case, String> zipCodeTable;

    @FXML
    private TableColumn<Case, String> diagnosisTable;

    @FXML
    private TableColumn<Case, String> recoveryTable;

    @FXML
    private TableColumn<Case, String> deathTable;


    @FXML
    private Button allPersonsButton;

    @FXML
    private Button allCasesButton;

    @FXML
    private Button allContactButton;

    @FXML
    private Button searchFilterButton;

    @FXML
    private TextField filterInput;

    @FXML
    private ComboBox<String> filterComboBox;

    @FXML
    private ComboBox<String> chooseTableComboBox;




    /* Here we will initialize all the functions and events on click */


    // Click event that open and close the menu bar
    @FXML
    public void menuClick(MouseEvent event) {
        if (menuIsHide) {
            menuBar.setVisible(true);
            menuIsHide = false;
        } else {
            menuBar.setVisible(false);
            menuIsHide = true;
        }
    }

    // Click event that opens and close the create case panel
    @FXML
    public void menuCreateClick(MouseEvent event) {
        if (createCaseHide) {
            createCasePanel.setVisible(true);
            createCaseHide = false;
        } else {
            createCasePanel.setVisible(false);
            createCaseHide = true;
        }
    }

    // Click event that opens and close the find persons panel
    @FXML
    public void menuFindPersonClick(MouseEvent event) {
        if (findPersonHide) {
            findPersonPanel.setVisible(true);
            findPersonHide = false;
        } else {
            findPersonPanel.setVisible(false);
            findPersonHide = true;
        }
    }

    // Click event that will take the value from the create case panel
    // and create the case in the database
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

        if (municipalityInput.getValue().isEmpty() || firstNameInput.getText().isEmpty() ||
            lastNameInput.getText().isEmpty() || ageInput.getText().isEmpty() ||
            phoneNumberInput.getText().isEmpty() || addressInput.getText().isEmpty() ||
            streetInput.getText().isEmpty() || zipCodeInput.getText().isEmpty() ||
            contactsInput.getText().isEmpty() || afmInput.getText().isEmpty() || diagnosisInput.getValue() == null) {

            JOptionPane.showMessageDialog(null, "Please fill all the field with *", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            // Initialize all the values we will need to create and insert the case in database
            // Municipality index must be +1 in order to match the case with the right municipality in database
            mun = municipalityInput.getSelectionModel().getSelectedIndex() + 1;
            fn = firstNameInput.getText();
            ln = lastNameInput.getText();
            ag = Integer.parseInt(ageInput.getText());
            pn = phoneNumberInput.getText();
            ad = addressInput.getText();
            st = streetInput.getText();
            zc = zipCodeInput.getText();
            cn = Integer.parseInt(contactsInput.getText());
            dd = String.valueOf(diagnosisInput.getValue());
            af = Integer.parseInt(afmInput.getText());

            // Recovered data and death date
            rd = String.valueOf(recoveryInput.getValue());
            dt = String.valueOf(deathInput.getValue());

            // Creating a instance of CaseDAO in order to insert the case in database
            CaseDAO caseDAO = new CaseDAO();

            // There are 3 chances (new Case, new Recovered Case or new Dead Case)
            if (recoveryInput.getValue() == null && deathInput.getValue() == null) {
                parseAFM = af;
                Case krousma = new Case(dd, cn, af, fn, ln, ag, pn, mun, ad,
                        st, zc);

                try {
                    caseDAO.createCaseActive(krousma);
                    JOptionPane.showMessageDialog(null, "Case has been created successfully!");
                    clear_newCasePane(event);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "An error oquired: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {

                    totalContacts = cn;
                    numberLabel.setText(String.valueOf(totalContacts));
                    counterLabel.setText(String.valueOf(counterContacts));

                    if (addContactsHide) {
                        addContactsPanel.setVisible(true);
                        addContactsHide = false;
                    }
                    if (!createCaseHide) {
                        createCasePanel.setVisible(false);
                        createCaseHide = true;
                    }
                }

            } else if (recoveryInput.getValue() != null && deathInput.getValue() == null) {
                parseAFM = af;
                Case krousma = new Case(cn, dd, rd, af, fn, ln, ag, pn, mun,
                        ad, st, zc);
                try {
                    caseDAO.createCaseRecovery(krousma);
                    JOptionPane.showMessageDialog(null, "Case has been created successfully!");
                    clear_newCasePane(event);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "An error oquired: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    System.out.println("Case created successfully..");
                    System.out.println("The case is recovery..");

                    totalContacts = cn;
                    numberLabel.setText(String.valueOf(totalContacts));
                    counterLabel.setText(String.valueOf(counterContacts));

                    if (addContactsHide) {
                        addContactsPanel.setVisible(true);
                        addContactsHide = false;
                    }
                    if (!createCaseHide) {
                        createCasePanel.setVisible(false);
                        createCaseHide = true;
                    }
                }

            }else if (recoveryInput.getValue() == null && deathInput.getValue() != null){
                parseAFM = af;
                Case krousma = new Case(dd, dt, cn, af, fn, ln, ag, pn, mun, ad,
                        st, zc);
                try {
                    caseDAO.createCaseDead(krousma);
                    JOptionPane.showMessageDialog(null, "Case has been created successfully!");
                    clear_newCasePane(event);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "An error oquired: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    totalContacts = cn;
                    numberLabel.setText(String.valueOf(totalContacts));
                    counterLabel.setText(String.valueOf(counterContacts));
                    counterContacts = 1;

                    if (addContactsHide) {
                        addContactsPanel.setVisible(true);
                        addContactsHide = false;
                    }
                    if (!createCaseHide) {
                        createCasePanel.setVisible(false);
                        createCaseHide = true;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "You cant enter both recovery date and death date", "Warning", JOptionPane.WARNING_MESSAGE);
            }


        }

    }

    // Clear button. It clears the fields of new case pane
    @FXML
    void clear_newCasePane(MouseEvent event) {
        firstNameInput.clear();
        lastNameInput.clear();
        ageInput.clear();
        phoneNumberInput.clear();
        addressInput.clear();
        streetInput.clear();
        zipCodeInput.clear();
        contactsInput.clear();
        diagnosisInput.getEditor().clear();
        deathInput.getEditor().clear();
        recoveryInput.getEditor().clear();
        afmInput.clear();
        municipalityInput.getSelectionModel().clearSelection();
    }

    // Cancel button. It cancels the creation of a case in new case pane
    @FXML
    void cancelB_newCase(MouseEvent event) {
        clear_newCasePane(event);
        if (!createCaseHide) {
            createCasePanel.setVisible(false);
            createCaseHide = true;
        }
    }

    // Click event that will take the value from the create contact panel
    // and create the number contacts that the user inserted on the create case panel
    // This panel is auto open when the user finish the creation of a case
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
        }
        if (!lastNameCInput.getText().isEmpty()) {
            lnC = lastNameCInput.getText();
        }
        if (!ageCInput.getText().isEmpty()) {
            ageC = Integer.parseInt(ageCInput.getText());
        }
        if (!phoneNumberCInput.getText().isEmpty()) {
            pnC = phoneNumberCInput.getText();
        }
        if (municipalityCInput.getValue() != null) {
            munC = municipalityCInput.getSelectionModel().getSelectedIndex();
            munC++;
        }
        if (!addressCInput.getText().isEmpty()) {
            addC = addressCInput.getText();
        }
        if (!streetCInput.getText().isEmpty()) {
            stC = streetCInput.getText();
        }
        if (!zipCCodeInput.getText().isEmpty()) {
            zcC = zipCCodeInput.getText();
        }
        if (!afmCInput.getText().isEmpty()) {
            afmC = Integer.parseInt(afmCInput.getText());
            conID = Integer.parseInt(afmCInput.getText());
        }
        if ((!firstNameCInput.getText().isEmpty()) && (!lastNameCInput.getText().isEmpty()) && (!ageCInput.getText().isEmpty()) && (!phoneNumberCInput.getText().isEmpty()) && (municipalityCInput.getValue() != null) && (!addressCInput.getText().isEmpty()) && (!streetCInput.getText().isEmpty()) && (!zipCCodeInput.getText().isEmpty()) && (!afmCInput.getText().isEmpty())) {
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
                municipalityCInput.getSelectionModel().clearSelection();
                addressCInput.clear();
                streetCInput.clear();
                zipCCodeInput.clear();
                afmCInput.clear();
                if (counterContacts > totalContacts) {
                    if (!addContactsHide) {
                        addContactsPanel.setVisible(false);
                        addContactsHide = true;
                    }
                }
            }
        }

    }


    // Click event that opens a panel to create a contact for a specific case
    @FXML
    public void menuAddContactClick(MouseEvent event) {
        if (addContactUniqueHide) {
            addContactUniquePanel.setVisible(true);
            addContactUniqueHide = false;
        } else {
            addContactUniquePanel.setVisible(false);
            addContactUniqueHide = true;
        }
    }


    // Click event that take the values from the panel that creates a contact
    // for a specific case and initialize that case-contact bond in the database,
    // and also create the new contact
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
        if (!municipalityCQInput.getValue().isEmpty()) {
            munC = municipalityCQInput.getSelectionModel().getSelectedIndex() + 1;
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
        if (!afmCQKrousmatosInput.getText().isEmpty()) {
            afmK = Integer.parseInt(afmCQKrousmatosInput.getText());
        }
        if ((!firstNameCQInput.getText().isEmpty()) && (!lastNameCQInput.getText().isEmpty()) && (!ageCQInput.getText().isEmpty()) && (!phoneNumberCQInput.getText().isEmpty()) && (!municipalityCQInput.getValue().isEmpty()) && (!addressCQInput.getText().isEmpty()) && (!streetCQInput.getText().isEmpty()) && (!zipCQCodeInput.getText().isEmpty()) && (!afmCQInput.getText().isEmpty()) && (!afmCQKrousmatosInput.getText().isEmpty())) {
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
                municipalityCQInput.getSelectionModel().clearSelection();
                addressCQInput.clear();
                streetCQInput.clear();
                zipCQCodeInput.clear();
                afmCQInput.clear();
                afmCQKrousmatosInput.clear();

                if (!addContactUniqueHide) {
                    addContactUniquePanel.setVisible(false);
                    addContactUniqueHide = true;

                }
            }
        }

    }


    @FXML
    public void allCasesClick(MouseEvent event) {
        ObservableList<Case> oblist = FXCollections.observableArrayList();
        try{
            Connection con = DB.getConnection();
            String querry = "SELECT * FROM Persons WHERE ContactID IS NULL;";
            PreparedStatement stmt = con.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                if(rs.getString("contactsNumber") != null){
                    contactsNumberSQL = Integer.parseInt(rs.getString("contactsNumber"));
                }else{
                    contactsNumberSQL = 0;
                }
                oblist.add(new Case(
                        contactsNumberSQL, rs.getString("Diagnosis"),
                        rs.getString("Recovery"), Integer.parseInt(rs.getString("AFM")),
                        rs.getString("firstName"), rs.getString("lastName"),
                        Integer.parseInt(rs.getString("age")), rs.getString("phoneNumber"),
                        Integer.parseInt(rs.getString("dimosID")), rs.getString("address"),
                        rs.getString("streetNumber"), rs.getString("zipCode")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>("dimosID"));
        addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
        stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        diagnosisTable.setCellValueFactory(new PropertyValueFactory<>("Diagnosis"));
        recoveryTable.setCellValueFactory(new PropertyValueFactory<>("Recovery"));
        deathTable.setCellValueFactory(new PropertyValueFactory<>("Death"));
        numberOfContactsTable.setCellValueFactory(new PropertyValueFactory<>("contactsNumber"));
        afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
        personsTable.setItems(oblist);

    }

    @FXML
    public void allContactsClick(MouseEvent event) {
        ObservableList<Case> oblist = FXCollections.observableArrayList();
        try{
            Connection con = DB.getConnection();
            String querry = "SELECT * FROM Persons WHERE ContactID IS NOT NULL;";
            PreparedStatement stmt = con.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                if(rs.getString("contactsNumber") != null){
                    contactsNumberSQL = Integer.parseInt(rs.getString("contactsNumber"));
                }else{
                    contactsNumberSQL = 0;
                }
                oblist.add(new Case(
                        contactsNumberSQL, rs.getString("Diagnosis"),
                        rs.getString("Recovery"), Integer.parseInt(rs.getString("AFM")),
                        rs.getString("firstName"), rs.getString("lastName"),
                        Integer.parseInt(rs.getString("age")), rs.getString("phoneNumber"),
                        Integer.parseInt(rs.getString("dimosID")), rs.getString("address"),
                        rs.getString("streetNumber"), rs.getString("zipCode")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>("dimosID"));
        addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
        stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        diagnosisTable.setCellValueFactory(new PropertyValueFactory<>("Diagnosis"));
        recoveryTable.setCellValueFactory(new PropertyValueFactory<>("Recovery"));
        deathTable.setCellValueFactory(new PropertyValueFactory<>("Death"));
        numberOfContactsTable.setCellValueFactory(new PropertyValueFactory<>("contactsNumber"));
        afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
        personsTable.setItems(oblist);

    }

    @FXML
    public void allPersonsClick(MouseEvent event) {
        ObservableList<Case> oblist = FXCollections.observableArrayList();
        try{
            Connection con = DB.getConnection();
            String querry = "SELECT * FROM Persons;";
            PreparedStatement stmt = con.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                if(rs.getString("contactsNumber") != null){
                    contactsNumberSQL = Integer.parseInt(rs.getString("contactsNumber"));
                }else{
                    contactsNumberSQL = 0;
                }
                oblist.add(new Case(
                        contactsNumberSQL, rs.getString("Diagnosis"),
                        rs.getString("Recovery"), Integer.parseInt(rs.getString("AFM")),
                        rs.getString("firstName"), rs.getString("lastName"),
                        Integer.parseInt(rs.getString("age")), rs.getString("phoneNumber"),
                        Integer.parseInt(rs.getString("dimosID")), rs.getString("address"),
                        rs.getString("streetNumber"), rs.getString("zipCode")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>("dimosID"));
        addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
        stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        diagnosisTable.setCellValueFactory(new PropertyValueFactory<>("Diagnosis"));
        recoveryTable.setCellValueFactory(new PropertyValueFactory<>("Recovery"));
        deathTable.setCellValueFactory(new PropertyValueFactory<>("Death"));
        numberOfContactsTable.setCellValueFactory(new PropertyValueFactory<>("contactsNumber"));
        afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
        personsTable.setItems(oblist);

    }



    @FXML
    public void searchFilterClick(MouseEvent event) {
        String inputFilter = filterInput.getText();
        String querry = "SELECT * FROM Persons WHERE ContactID IS NULL;";
        switch (chooseTableComboBox.getValue()){
            case "Persons":
                switch (filterComboBox.getValue()){
                    case "ΑΦΜ":
                        querry = "SELECT * FROM Persons WHERE AFM = "+ inputFilter +";";
                        break;
                    case "First Name":
                        querry = "SELECT * FROM Persons WHERE FirstName = '"+ inputFilter +"';";
                        break;
                    case "Last Name":
                        querry = "SELECT * FROM Persons WHERE LastName = '"+ inputFilter +"';";
                        break;
                    case "Age":
                        querry = "SELECT * FROM Persons WHERE Age = "+ inputFilter +";";
                        break;
                    case "Phone Number":
                        querry = "SELECT * FROM Persons WHERE PhoneNumber = '"+ inputFilter +"';";
                        break;
                    case "Municipality":
                        querry = "SELECT * FROM Persons WHERE DimosID = "+ inputFilter +";";
                        break;
                    case "Address":
                        querry = "SELECT * FROM Persons WHERE Address = '"+ inputFilter +"';";
                        break;
                    case "Street Number":
                        querry = "SELECT * FROM Persons WHERE StreetNumber = '"+ inputFilter +"';";
                        break;
                    case "Zip Code":
                        querry = "SELECT * FROM Persons WHERE ZipCode = '"+ inputFilter +"';";
                        break;
                    case "Diagnosis Date":
                        querry = "SELECT * FROM Persons WHERE Diagnosis = '"+ inputFilter +"';";
                        break;
                    case "Recovery Date":
                        querry = "SELECT * FROM Persons WHERE Recovery = '"+ inputFilter +"';";
                        break;
                    case "Death Date":
                        querry = "SELECT * FROM Persons WHERE Death = '"+ inputFilter +"';";
                        break;
                }
                break;

            case "Cases":
                System.out.println("Cases");
                switch (filterComboBox.getValue()){
                    case "ΑΦΜ":
                        System.out.println("AFM");
                        break;
                    case "First Name":
                        System.out.println("Firstname");
                        break;
                    case "Last Name":
                        System.out.println("Lastname");
                        break;
                    case "Age":
                        System.out.println("Age");
                        break;
                    case "Phone Number":
                        System.out.println("Phone Number");
                        break;
                    case "Municipality":
                        System.out.println("Municipality");
                        break;
                    case "Address":
                        System.out.println("Address");
                        break;
                    case "Street Number":
                        System.out.println("Street Number");
                        break;
                    case "Zip Code":
                        System.out.println("Zip Code");
                        break;
                    case "Diagnosis Date":
                        System.out.println("Diagnosis Date");
                        break;
                    case "Recovery Date":
                        System.out.println("Recovery Date");
                        break;
                    case "Death Date":
                        System.out.println("Death Date");
                        break;
                }
                break;

            case "Contacts":
                System.out.println("Contacts");
                switch (filterComboBox.getValue()){
                    case "ΑΦΜ":
                        System.out.println("AFM");
                        break;
                    case "First Name":
                        System.out.println("Firstname");
                        break;
                    case "Last Name":
                        System.out.println("Lastname");
                        break;
                    case "Age":
                        System.out.println("Age");
                        break;
                    case "Phone Number":
                        System.out.println("Phone Number");
                        break;
                    case "Municipality":
                        System.out.println("Municipality");
                        break;
                    case "Address":
                        System.out.println("Address");
                        break;
                    case "Street Number":
                        System.out.println("Street Number");
                        break;
                    case "Zip Code":
                        System.out.println("Zip Code");
                        break;
                    case "Diagnosis Date":
                        System.out.println("Diagnosis Date");
                        break;
                    case "Recovery Date":
                        System.out.println("Recovery Date");
                        break;
                    case "Death Date":
                        System.out.println("Death Date");
                        break;
                }
                break;
        }
        ObservableList<Case> oblist = FXCollections.observableArrayList();
        try{
            Connection con = DB.getConnection();
            PreparedStatement stmt = con.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                if(rs.getString("contactsNumber") != null){
                    contactsNumberSQL = Integer.parseInt(rs.getString("contactsNumber"));
                }else{
                    contactsNumberSQL = 0;
                }
                oblist.add(new Case(
                        contactsNumberSQL, rs.getString("Diagnosis"),
                        rs.getString("Recovery"), Integer.parseInt(rs.getString("AFM")),
                        rs.getString("firstName"), rs.getString("lastName"),
                        Integer.parseInt(rs.getString("age")), rs.getString("phoneNumber"),
                        Integer.parseInt(rs.getString("dimosID")), rs.getString("address"),
                        rs.getString("streetNumber"), rs.getString("zipCode")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>("dimosID"));
        addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
        stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        diagnosisTable.setCellValueFactory(new PropertyValueFactory<>("Diagnosis"));
        recoveryTable.setCellValueFactory(new PropertyValueFactory<>("Recovery"));
        deathTable.setCellValueFactory(new PropertyValueFactory<>("Death"));
        numberOfContactsTable.setCellValueFactory(new PropertyValueFactory<>("contactsNumber"));
        afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
        personsTable.setItems(oblist);
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initialize in all comboBox that the use choose a municipality to have a default value
        municipalityInput.getSelectionModel().select("Select municipality");
        municipalityCInput.getSelectionModel().select("Select municipality");
        municipalityCQInput.getSelectionModel().select("Select municipality");

        // Initialize the chooses that the comboBox will have
        municipalityInput.getItems().addAll("Αθηναίων", "Βύρωνος", "Γαλατσίου", "Δάφνης – Υμηττού", "Ζωγράφου",
                "Ηλιουπόλεως", "Καισαριανής", "Φιλαδελφείας – Χαλκηδόνος", "Αγίας Παρασκευής", "Αμαρουσίου", "Βριλησσίων",
                "Ηρακλείου", "Κηφισιάς", "Λυκόβρυσης – Πεύκης", "Μεταμορφώσεως", "Νέας Ιωνίας", "Παπάγου – Χολαργού", "Πεντέλης",
                "Φιλοθέης – Ψυχικού", "Χαλανδρίου", "Περιστερίου", "Αγίας Βαρβάρας", "Αγίων Αναργύρων – Καματερού", "Αιγάλεω",
                "Ιλίου", "Πετρουπόλεως", "Χαϊδαρίου", "Καλλιθέας", "Αγίου Δημητρίου", "Αλίμου", "Γλυφάδας", "Ελληνικού – Αργυρούπολης",
                "Μοσχάτου – Ταύρου", "Νέας Σμύρνης", "Παλαιού Φαλήρου", "Αχαρνών", "Βάρης – Βούλας – Βουλιαγμένης", "Διονύσου", "Κρωπίας",
                "Λαυρεωτικής", "Μαραθώνα", "Μαρκοπούλου Μεσογαίας", "Παιανίας", "Παλλήνης"
                , "Ραφήνας – Πικερμίου", "Σαρωνικού", "Σπάτων", "Ωρωπού", "Ελευσίνας", "Ασπροπύργου", "Μάνδρας – Ειδυλλίας",
                "Μεγαρέων", "Φυλής", "Πειραιώς", "Κερατσινίου – Δραπετσώνας", "Κορυδαλλού", "Νίκαιας – Αγίου Ιωάννη Ρέντη",
                "Περάματος", "Σαλαμίνος", "Αγκιστρίου", "Αίγινας", "Κυθήρων", "Πόρου", "Σπετσών", "Τροιζηνίας", "Ύδρας");

        municipalityCInput.setItems(municipalityInput.getItems());
        municipalityCQInput.setItems(municipalityInput.getItems());

        chooseTableComboBox.getSelectionModel().select("Select Table");
        chooseTableComboBox.getItems().addAll("Persons", "Cases", "Contacts");

        filterComboBox.getSelectionModel().select("Select Column");
        filterComboBox.getItems().addAll("ΑΦΜ","First Name", "Last Name", "Phone Number", "Age", "Municipality",
                                                    "Address", "Street Number", "Zip Code", "Diagnosis Date", "Recovery Date",
                                                    "Death Date");



    }

}

