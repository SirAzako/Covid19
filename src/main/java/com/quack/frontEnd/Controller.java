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

        if(municipalityInput.getValue() != null){

          mun = municipalityInput.getSelectionModel().getSelectedIndex();
          mun++;
        }
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
                diagnosisInput.getEditor().clear();
                deathInput.getEditor().clear();
                recoveryInput.getEditor().clear();
                afmInput.clear();


                if (addContactsHide) {
                    addContactsPanel.setVisible(true);
                    addContactsHide = false;
                }
                if (!createCaseHide) {
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
                diagnosisInput.getEditor().clear();
                deathInput.getEditor().clear();
                recoveryInput.getEditor().clear();
                afmInput.clear();
                municipalityInput.getSelectionModel().clearSelection();

                if (addContactsHide) {
                    addContactsPanel.setVisible(true);
                    addContactsHide = false;
                }
                if (!createCaseHide) {
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
                diagnosisInput.getEditor().clear();
                deathInput.getEditor().clear();
                recoveryInput.getEditor().clear();
                afmInput.clear();
                municipalityInput.getSelectionModel().clearSelection();

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
        if (!afmCQKrousmatosInput.getText().isEmpty()) {
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

                if (!addContactUniqueHide) {
                    addContactUniquePanel.setVisible(false);
                    addContactUniqueHide = true;

                }
            }
        }

    }

    ObservableList<Case> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

        municipalityCInput.getItems().addAll("Αθηναίων", "Βύρωνος", "Γαλατσίου", "Δάφνης – Υμηττού", "Ζωγράφου",
                "Ηλιουπόλεως", "Καισαριανής", "Φιλαδελφείας – Χαλκηδόνος", "Αγίας Παρασκευής", "Αμαρουσίου", "Βριλησσίων",
                "Ηρακλείου", "Κηφισιάς", "Λυκόβρυσης – Πεύκης", "Μεταμορφώσεως", "Νέας Ιωνίας", "Παπάγου – Χολαργού", "Πεντέλης",
                "Φιλοθέης – Ψυχικού", "Χαλανδρίου", "Περιστερίου", "Αγίας Βαρβάρας", "Αγίων Αναργύρων – Καματερού", "Αιγάλεω",
                "Ιλίου", "Πετρουπόλεως", "Χαϊδαρίου", "Καλλιθέας", "Αγίου Δημητρίου", "Αλίμου", "Γλυφάδας", "Ελληνικού – Αργυρούπολης",
                "Μοσχάτου – Ταύρου", "Νέας Σμύρνης", "Παλαιού Φαλήρου", "Αχαρνών", "Βάρης – Βούλας – Βουλιαγμένης", "Διονύσου", "Κρωπίας",
                "Λαυρεωτικής", "Μαραθώνα", "Μαρκοπούλου Μεσογαίας", "Παιανίας", "Παλλήνης"
                , "Ραφήνας – Πικερμίου", "Σαρωνικού", "Σπάτων", "Ωρωπού", "Ελευσίνας", "Ασπροπύργου", "Μάνδρας – Ειδυλλίας",
                "Μεγαρέων", "Φυλής", "Πειραιώς", "Κερατσινίου – Δραπετσώνας", "Κορυδαλλού", "Νίκαιας – Αγίου Ιωάννη Ρέντη",
                "Περάματος", "Σαλαμίνος", "Αγκιστρίου", "Αίγινας", "Κυθήρων", "Πόρου", "Σπετσών", "Τροιζηνίας", "Ύδρας");


        System.out.println("1");
        try{
            System.out.println("2");
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
                System.out.println("3");
                oblist.add(new Case(
                        (contactsNumberSQL), (rs.getString("Diagnosis")),
                        (rs.getString("Recovery")), (Integer.parseInt(rs.getString("AFM"))),
                        (rs.getString("firstName")), (rs.getString("lastName")), (Integer.parseInt(rs.getString("age"))),
                        (rs.getString("phoneNumber")), (Integer.parseInt(rs.getString("dimosID"))), (rs.getString("address")),
                        (rs.getString("streetNumber")), (rs.getString("zipCode"))));
            }

        }catch (Exception e){

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



}

