package com.quack.frontend;

import com.quack.backend.Case;
import com.quack.backend.Contact;
import com.quack.backend.Filters;
import com.quack.db.CaseDAO;
import com.quack.db.ContactDAO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.JOptionPane;

/**
 * In Controller done all management for the gui
 *
 * @version 1.0.1 11 Jan 2021
 */
public class Controller implements Initializable {
    private boolean menuHide = true;
    private boolean createCaseHide = true;
    private boolean addContactsHide = true;
    private boolean addContactUniqueHide = true;
    private boolean findPersonHide = true;
    private boolean editProfileHide = true;
    private boolean statsHide = true;
    private int totalContacts = 0;
    private int counterContacts = 1;
    private int parseAfm = 0;
    private int contactsNumberSql = 0;

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

    @FXML
    private Group menuEditProfileButton;


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
    private TextField firstNameCoInput;

    @FXML
    private TextField lastNameCoInput;

    @FXML
    private TextField ageCoInput;

    @FXML
    private TextField phoneNumberCoInput;

    @FXML
    private ComboBox<String> municipalityCoInput;

    @FXML
    private TextField addressCoInput;

    @FXML
    private TextField streetCoInput;

    @FXML
    private TextField zipCodeCoInput;

    @FXML
    private TextField afmCoInput;

    @FXML
    private Button submitContactButton;

    //Edit profile
    @FXML
    private AnchorPane editProfilePanel;

    @FXML
    private TextField afmEditInput;

    @FXML
    private Button editPersonButton;

    @FXML
    private TextField firstNameEditInput;

    @FXML
    private TextField lastNameEditInput;

    @FXML
    private TextField ageEditInput;

    @FXML
    private TextField phoneNumberEditInput;

    @FXML
    private ComboBox<String> municipalityEditInput;

    @FXML
    private TextField addressEditInput;

    @FXML
    private TextField streetEditInput;

    @FXML
    private TextField zipCodeEditInput;

    @FXML
    private TextField contactsEditInput;

    @FXML
    private DatePicker diagnosisEditInput;

    @FXML
    private DatePicker recoveryEditInput;

    @FXML
    private DatePicker deathEditInput;

    @FXML
    private Button submitEditPersonButton;

    // Add a contact to a specific case (AnchorPane, Fields, Button)
    @FXML
    private AnchorPane addContactUniquePanel;

    @FXML
    private TextField firstNameCoUnInput;

    @FXML
    private TextField lastNameCoUnInput;

    @FXML
    private TextField ageCoUnInput;

    @FXML
    private TextField phoneNumberCoUnInput;

    @FXML
    private ComboBox<String> municipalityCoUnInput;

    @FXML
    private TextField addressCoUnInput;

    @FXML
    private TextField streetCoUnInput;

    @FXML
    private TextField zipCodeCoUnInput;

    @FXML
    private TextField afmCoUnInput;

    @FXML
    private TextField afmCoUnKrousmatosInput;

    @FXML
    private Button submitContactUniqueButton;

    @FXML
    private Button clearAddContactUniqButton;

    @FXML
    private Button cancelAddContactUniqButton;


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
    private TextField filterContactInput;

    @FXML
    private Label resultsInput;

    @FXML
    private ComboBox<String> chooseColumnComboBox;

    @FXML
    private ComboBox<String> chooseTableComboBox;

    //Stats
    @FXML
    private AnchorPane statsPanel;

    /* Here we will initialize all the functions and events on click */


    // Click event that open and close the menu bar
    @FXML
    public void menuClick(MouseEvent event) {
        openPanels(menuBar);
    }


    // Click event that opens and close the create case panel
    @FXML
    public void menuCreateClick(MouseEvent event) {
        openPanels(createCasePanel);
    }


    // Click event that opens and close the find persons panel
    @FXML
    public void menuFindPersonClick(MouseEvent event) {
        openPanels(findPersonPanel);
    }


    @FXML
    public void menuContactClick(MouseEvent event) {
        openPanels(addContactUniquePanel);
    }


    @FXML
    public void menuEditProfileClick(MouseEvent event) {
        openPanels(editProfilePanel);
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

        // If at least one of the "must fill" fields is empty
        // then show a message else continue the process
        if (municipalityInput.getSelectionModel().getSelectedIndex() == -1
                || firstNameInput.getText().isEmpty()
                || lastNameInput.getText().isEmpty() || ageInput.getText().isEmpty()
                || phoneNumberInput.getText().isEmpty() || addressInput.getText().isEmpty()
                || streetInput.getText().isEmpty() || zipCodeInput.getText().isEmpty()
                || contactsInput.getText().isEmpty()
                || afmInput.getText().isEmpty()
                || diagnosisInput.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Please fill all the field with *");
        } else {
            try {
                // Initialize all the values we will need to create and insert the case in database
                // Municipality index must be +1 in order to match
                // the case with the right municipality in database
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


                // There are 3 chances (new Case, new Recovered Case or new Dead Case)
                if (recoveryInput.getValue() == null && deathInput.getValue() == null) {
                    parseAfm = af;

                    Case krousma = new Case(dd, cn, af, fn, ln, ag, pn, mun, ad,
                            st, zc);
                    checkContactsNum(krousma);
                    clearNewCasePane(event);

                } else if (recoveryInput.getValue() != null && deathInput.getValue() == null) {
                    parseAfm = af;

                    Case krousma = new Case(cn, dd, rd, af, fn, ln, ag, pn, mun,
                            ad, st, zc);
                    checkContactsNum(krousma);
                    clearNewCasePane(event);

                } else if (recoveryInput.getValue() == null && deathInput.getValue() != null) {
                    parseAfm = af;

                    Case krousma = new Case(dd, dt, cn, af, fn, ln, ag, pn, mun, ad,
                            st, zc);
                    checkContactsNum(krousma);
                    clearNewCasePane(event);

                } else {
                    JOptionPane.showMessageDialog(null,
                            "You cant enter both recovery date and death date",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }


    // Clear button. It clears the fields of new case pane
    @FXML
    public void clearNewCasePane(MouseEvent event) {
        clearFields(createCasePanel);
    }


    // Cancel button. It cancels the creation of a case in new case pane
    @FXML
    public void cancelNewCase(MouseEvent event) {
        clearNewCasePane(event);
        createCasePanel.setVisible(false);
        createCaseHide = true;
    }


    // In this method we give the case object and depend to the contactNumber
    // it goes to the next Panel or not
    public void checkContactsNum(Case krousma) throws Exception {

        if (krousma.getContactsNumber() == 0) {
            // If the case didn't had contacts then just create the case and close the pane
            insertCase(krousma);

        } else if (krousma.getContactsNumber() > 0) {
            // If the case had contacts then create the case and open the addContactsPanel
            insertCase(krousma);

            // Update the variables that count how many contacts you will add
            totalContacts = krousma.getContactsNumber();
            numberLabel.setText(String.valueOf(totalContacts));
            counterLabel.setText(String.valueOf(counterContacts));

            // Open addContactPanel
            // in order to add the number of contacts the user said
            addContactsPanel.setVisible(true);
            addContactsHide = false;
            createCasePanel.setVisible(false);
            createCaseHide = true;

        } else {
            // if the contacts number is < 0 then an error will occur
            throw new Exception(
                    "What do you mean you contacted with " + krousma.getContactsNumber() + " people??");
        }

        // Close the createCasePanel
        createCasePanel.setVisible(false);
        createCaseHide = true;
    }


    // This method is doing the insertion in the database
    public void insertCase(Case krousma) throws Exception {
        // Creating a instance of CaseDAO in order to insert the case in database
        CaseDAO casedao = new CaseDAO();

        // Insert the case
        casedao.createCaseActive(krousma);
        JOptionPane.showMessageDialog(null,
                "Case has been created successfully!");

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
        int conId = 0;

        counterContacts++;
        counterLabel.setText(String.valueOf(counterContacts));

        if (firstNameCoInput.getText().isEmpty() || lastNameCoInput.getText().isEmpty()
                || ageCoInput.getText().isEmpty() || phoneNumberCoInput.getText().isEmpty()
                || municipalityCoInput.getSelectionModel().getSelectedIndex() == -1
                || addressCoInput.getText().isEmpty() || streetCoInput.getText().isEmpty()
                || zipCodeCoInput.getText().isEmpty() || afmCoInput.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null, "Please fill all the fields with *");
        } else {
            try {
                fnC = firstNameCoInput.getText();
                lnC = lastNameCoInput.getText();
                ageC = Integer.parseInt(ageCoInput.getText());
                pnC = phoneNumberCoInput.getText();
                munC = municipalityCoInput.getSelectionModel().getSelectedIndex() + 1;
                addC = addressCoInput.getText();
                stC = streetCoInput.getText();
                zcC = zipCodeCoInput.getText();
                afmC = Integer.parseInt(afmCoInput.getText());
                conId = Integer.parseInt(afmCoInput.getText());

                // Create the object to add it to DB
                Contact contact = new Contact(afmC, conId, fnC, lnC, ageC, pnC,
                        munC, addC, stC, zcC);
                insertContact(contact, parseAfm);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        // Clear the fields to add a new contact
        // if the contact number given from the previous panel is not yet reached
        clearAddContacts(event);

        // if the counter of contacts added surpass the contact number given
        // from the createCase panel then close this panel
        if (counterContacts > totalContacts) {
            addContactsPanel.setVisible(false);
            addContactsHide = true;
            counterContacts = 1;
        }

    }


    // A method that take the contact and insert it in the database
    // Also it creates the connection with the case from the previous panel (createCase)
    public void insertContact(Contact contact, int krousmaAFM) throws Exception {
        ContactDAO contactDao = new ContactDAO();

        try {
            // Create the contact and create also the "connection" case to contact
            contactDao.createContact(contact);
            contactDao.connectCaseContact(krousmaAFM, contact);
            JOptionPane.showMessageDialog(null, "Contact has been successfully created");

        } catch (Exception e) {
            // If something went wrong then delete the created contact in order not to have false data
            contactDao.deleteContact(contact.getAFM());
            throw new Exception("An error occurred: " + e.getMessage());
        }
    }


    // On click event in the addContacts Panel that cancel rest of the process
    @FXML
    public void cancelAddContacts(MouseEvent event) {
        // Clear the fields to add a new contact
        clearAddContacts(event);
        addContactsPanel.setVisible(false);
        addContactsHide = true;
    }


    // On click event in the addContacts Panel that clear the fields
    @FXML
    public void clearAddContacts(MouseEvent event) {
        clearFields(addContactsPanel);
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
        int conId = 0;
        int afmK = 0;

        // All the must fill field must not be null
        if (firstNameCoUnInput.getText().isEmpty() || lastNameCoUnInput.getText().isEmpty()
                || ageCoUnInput.getText().isEmpty() || phoneNumberCoUnInput.getText().isEmpty()
                || municipalityCoUnInput.getSelectionModel().getSelectedIndex() == -1
                || addressCoUnInput.getText().isEmpty() || streetCoUnInput.getText().isEmpty()
                || zipCodeCoUnInput.getText().isEmpty() || afmCoUnInput.getText().isEmpty()
                || afmCoUnKrousmatosInput.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please fill all the field with *");
        } else {
            // Reading all the values in order to continue the process
            try {
                fnC = firstNameCoUnInput.getText();
                lnC = lastNameCoUnInput.getText();
                ageC = Integer.parseInt(ageCoUnInput.getText());
                pnC = phoneNumberCoUnInput.getText();
                munC = municipalityCoUnInput.getSelectionModel().getSelectedIndex() + 1;
                addC = addressCoUnInput.getText();
                stC = streetCoUnInput.getText();
                zcC = zipCodeCoUnInput.getText();
                afmC = Integer.parseInt(afmCoUnInput.getText());
                afmK = Integer.parseInt(afmCoUnKrousmatosInput.getText());

                // Creating the contact object and inserting the database with the method insertContact
                Contact contact = new Contact(afmC, afmC, fnC, lnC, ageC, pnC,
                        munC, addC, stC, zcC);
                insertContact(contact, afmK);

                // Clear and close the panel
                cancelAddContactUniq(event);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null, "An error occurred: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }


    @FXML
    public void cancelAddContactUniq(MouseEvent event) {
        // clear the field and close the panel
        clearAddContactUniq(event);
        addContactUniquePanel.setVisible(false);
        addContactUniqueHide = true;
    }


    @FXML
    public void clearAddContactUniq(MouseEvent event) {
        clearFields(addContactUniquePanel);
    }


    @FXML
    public void allCasesClick(MouseEvent event) throws Exception {
        int counter = 0;
        CaseDAO caseDao = new CaseDAO();
        ObservableList<Case> oblist = caseDao.getCases();
        for (Case krousma : oblist) {
            counter++;
        }
        resultsInput.setText(String.valueOf(counter));

        try {
            caseDao.getPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }

        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>("dimosName"));
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
    public void allContactsClick(MouseEvent event) throws Exception {
        int counter = 0;
        CaseDAO caseDao = new CaseDAO();
        ObservableList<Case> oblist = caseDao.getContacts();
        for (Case krousma : oblist) {
            counter++;
        }
        resultsInput.setText(String.valueOf(counter));
        try {
            caseDao.getPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }

        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>(("dimosName")));
        addressTable.setCellValueFactory(new PropertyValueFactory<>("address"));
        stNumberTable.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        zipCodeTable.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        afmTable.setCellValueFactory(new PropertyValueFactory<>("AFM"));
        personsTable.setItems(oblist);

    }


    @FXML
    public void allPersonsClick(MouseEvent event) throws Exception {
        int counter = 0;
        CaseDAO caseDao = new CaseDAO();
        ObservableList<Case> oblist = caseDao.getPersons();
        for (Case krousma : oblist) {
            counter++;
        }
        resultsInput.setText(String.valueOf(counter));
        System.out.println(counter);
        try {
            caseDao.getPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }
        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>(("dimosName")));
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
    public void searchFilterClick(MouseEvent event) throws Exception {
        int counter = 0;
        CaseDAO caseDao = new CaseDAO();
        Filters filter = new Filters();
        String table = filter.chooseTable(chooseTableComboBox.getValue());
        String column = filter.chooseColumn(chooseColumnComboBox.getValue());
        ObservableList<Case> oblist = caseDao.getPersonFilter(table, column, filterInput.getText());
        for (Case krousma : oblist) {
            counter++;
        }
        resultsInput.setText(String.valueOf(counter));


        firstNameTable.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTable.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberTable.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dimosTable.setCellValueFactory(new PropertyValueFactory<>(("dimosName")));
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
    public void searchFilterContactClick(MouseEvent event) {
        int counter = 0;
    }


    public void openPanels(AnchorPane panelOpen) {
        if (panelOpen == menuBar) {
            if (menuHide) {
                menuBar.setVisible(true);
                menuHide = false;
            } else {
                menuBar.setVisible(false);
                menuHide = true;
            }
        }
        if (panelOpen == createCasePanel) {
            if (createCaseHide) {
                createCasePanel.setVisible(true);
                createCaseHide = false;

                findPersonPanel.setVisible(false);
                findPersonHide = true;
                addContactUniquePanel.setVisible(false);
                addContactUniqueHide = true;
                editProfilePanel.setVisible(false);
                editProfileHide = true;
                statsPanel.setVisible(false);
                statsHide = true;
            } else {
                createCasePanel.setVisible(false);
                createCaseHide = true;
            }
        }

        if (panelOpen == findPersonPanel) {
            if (findPersonHide) {
                findPersonPanel.setVisible(true);
                findPersonHide = false;
                createCasePanel.setVisible(false);
                createCaseHide = true;
                addContactUniquePanel.setVisible(false);
                addContactUniqueHide = true;
                editProfilePanel.setVisible(false);
                editProfileHide = true;
                statsPanel.setVisible(false);
                statsHide = true;
            } else {
                findPersonPanel.setVisible(false);
                findPersonHide = true;
            }
        }

        if (panelOpen == addContactUniquePanel) {
            if (addContactUniqueHide) {
                addContactUniquePanel.setVisible(true);
                addContactUniqueHide = false;
                findPersonPanel.setVisible(false);
                findPersonHide = true;
                createCasePanel.setVisible(false);
                createCaseHide = true;
                editProfilePanel.setVisible(false);
                editProfileHide = true;
                statsPanel.setVisible(false);
                statsHide = true;
            } else {
                addContactUniquePanel.setVisible(false);
                addContactUniqueHide = true;
            }
        }
        if (panelOpen == editProfilePanel) {
            if (editProfileHide) {
                editProfilePanel.setVisible(true);
                editProfileHide = false;
                statsPanel.setVisible(false);
                statsHide = true;
                findPersonPanel.setVisible(false);
                findPersonHide = true;
                createCasePanel.setVisible(false);
                createCaseHide = true;
                addContactUniquePanel.setVisible(false);
                addContactUniqueHide = true;

            } else {
                editProfilePanel.setVisible(false);
                editProfileHide = true;
            }
        }
        if (panelOpen == statsPanel) {
            if (statsHide) {
                statsPanel.setVisible(true);
                statsHide = false;

                editProfilePanel.setVisible(false);
                editProfileHide = true;
                findPersonPanel.setVisible(false);
                findPersonHide = true;
                createCasePanel.setVisible(false);
                createCaseHide = true;
                addContactUniquePanel.setVisible(false);
                addContactUniqueHide = true;

            } else {
                statsPanel.setVisible(false);
                statsHide = true;
            }
        }


    }

    @FXML
    void submitEditPersonClick(MouseEvent event) {
        CaseDAO caseDao = new CaseDAO();
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

        // If at least one of the "must fill" fields is empty
        // then show a message else continue the process
        if (municipalityEditInput.getSelectionModel().getSelectedIndex() == -1
                || firstNameEditInput.getText().isEmpty()
                || lastNameEditInput.getText().isEmpty() || ageEditInput.getText().isEmpty()
                || phoneNumberEditInput.getText().isEmpty() || addressEditInput.getText().isEmpty()
                || streetEditInput.getText().isEmpty() || zipCodeEditInput.getText().isEmpty()
                || contactsEditInput.getText().isEmpty()
                || afmEditInput.getText().isEmpty()
                || diagnosisEditInput.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Please fill all the field with *");
        } else {
            try {
                // Initialize all the values we will need to create and insert the case in database
                // Municipality index must be +1 in order to match
                // the case with the right municipality in database
                mun = municipalityEditInput.getSelectionModel().getSelectedIndex() + 1;
                fn = firstNameEditInput.getText();
                ln = lastNameEditInput.getText();
                ag = Integer.parseInt(ageEditInput.getText());
                pn = phoneNumberEditInput.getText();
                ad = addressEditInput.getText();
                st = streetEditInput.getText();
                zc = zipCodeEditInput.getText();
                cn = Integer.parseInt(contactsEditInput.getText());
                dd = String.valueOf(diagnosisEditInput.getValue());
                af = Integer.parseInt(afmEditInput.getText());

                // Recovered data and death date
                rd = String.valueOf(recoveryEditInput.getValue());
                dt = String.valueOf(deathEditInput.getValue());

                // There are 3 chances (new Case, new Recovered Case or new Dead Case)
                if (recoveryEditInput.getValue() == null && deathEditInput.getValue() == null) {


                    Case krousma1 = new Case(dd, cn, af, fn, ln, ag, pn, mun, ad,
                            st, zc);

                    caseDao.updatePerson(af, krousma1);

                } else if (recoveryEditInput.getValue() != null && deathEditInput.getValue() == null) {


                    Case krousma1 = new Case(cn, dd, rd, af, fn, ln, ag, pn, mun,
                            ad, st, zc);

                    caseDao.updatePerson(af, krousma1);
                } else if (recoveryEditInput.getValue() == null && deathEditInput.getValue() != null) {


                    Case krousma1 = new Case(dd, dt, cn, af, fn, ln, ag, pn, mun, ad,
                            st, zc);

                    caseDao.updatePerson(af, krousma1);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "You cant enter both recovery date and death date",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                JOptionPane.showMessageDialog(null,
                        "Case has been updated successfully!");
            }

        }

    }

    @FXML
    public void editPersonClick(MouseEvent event) throws Exception {
        CaseDAO caseDao = new CaseDAO();
        String amfInput = afmEditInput.getText();
        try {
            ObservableList<Case> oblist = caseDao.getPersonAfm(amfInput);
            for (Case krousma : oblist) {

                firstNameEditInput.setText(krousma.getFirstName());
                lastNameEditInput.setText(krousma.getLastName());
                ageEditInput.setText(String.valueOf(krousma.getAge()));
                phoneNumberEditInput.setText(krousma.getPhoneNumber());
                addressEditInput.setText(krousma.getAddress());
                streetEditInput.setText(krousma.getStreetNumber());
                zipCodeEditInput.setText(krousma.getZipCode());
                contactsEditInput.setText(String.valueOf(krousma.getContactsNumber()));

                if (krousma.getDiagnosis() != null) {
                    diagnosisEditInput.setValue(LocalDate.parse(krousma.getDiagnosis()));
                }
                if (krousma.getRecovery() != null) {
                    recoveryEditInput.setValue(LocalDate.parse(krousma.getRecovery()));
                }
                if (krousma.getDeath() != null) {
                    deathEditInput.setValue(LocalDate.parse(krousma.getDeath()));
                }


            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Please do not leave the field blank.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    public void clearEditPerson(MouseEvent event) {
        clearFields(editProfilePanel);
    }


    @FXML
    public void cancelEditPerson(MouseEvent event) {
        openPanels(editProfilePanel);
    }

    public void clearFields(AnchorPane panel) {
        if (panel == createCasePanel) {
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
        } else if (panel == addContactsPanel) {
            firstNameCoInput.clear();
            lastNameCoInput.clear();
            ageCoInput.clear();
            phoneNumberCoInput.clear();
            municipalityCoInput.getSelectionModel().clearSelection();
            addressCoInput.clear();
            streetCoInput.clear();
            zipCodeCoInput.clear();
            afmCoInput.clear();
        } else if (panel == addContactUniquePanel) {
            firstNameCoUnInput.clear();
            lastNameCoUnInput.clear();
            ageCoUnInput.clear();
            phoneNumberCoUnInput.clear();
            municipalityCoUnInput.getSelectionModel().clearSelection();
            addressCoUnInput.clear();
            streetCoUnInput.clear();
            zipCodeCoUnInput.clear();
            afmCoUnInput.clear();
            afmCoUnKrousmatosInput.clear();
        } else if (panel == editProfilePanel) {
            firstNameEditInput.clear();
            lastNameEditInput.clear();
            ageEditInput.clear();
            phoneNumberEditInput.clear();
            addressEditInput.clear();
            streetEditInput.clear();
            zipCodeEditInput.clear();
            contactsEditInput.clear();
            diagnosisEditInput.getEditor().clear();
            deathEditInput.getEditor().clear();
            recoveryEditInput.getEditor().clear();
            afmEditInput.clear();
            municipalityEditInput.getSelectionModel().clearSelection();
        }

    }

    @FXML
    public void menuStatsClick(MouseEvent event) {
        openPanels(statsPanel);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initialize in all comboBox that the use choose a municipality to have a default value
        municipalityInput.getSelectionModel().select("Select municipality");
        municipalityCoInput.getSelectionModel().select("Select municipality");
        municipalityCoUnInput.getSelectionModel().select("Select municipality");
        municipalityEditInput.getSelectionModel().select("Select municipality");
        // Initialize the chooses that the comboBox will have
        municipalityInput.getItems().addAll("Αθηναίων", "Βύρωνος", "Γαλατσίου",
                "Δάφνης – Υμηττού", "Ζωγράφου", "Ηλιουπόλεως", "Καισαριανής", "Φιλαδελφείας – ",
                "Χαλκηδόνος", "Αγίας Παρασκευής", "Αμαρουσίου", "Βριλησσίων", "Ηρακλείου", "Κηφισιάς",
                "Λυκόβρυσης – Πεύκης", "Μεταμορφώσεως", "Νέας Ιωνίας", "Παπάγου – Χολαργού", "Πεντέλης",
                "Φιλοθέης – Ψυχικού", "Χαλανδρίου", "Περιστερίου", "Αγίας Βαρβάρας",
                "Αγίων Αναργύρων – Καματερού", "Αιγάλεω", "Ιλίου", "Πετρουπόλεως", "Χαϊδαρίου",
                "Καλλιθέας", "Αγίου Δημητρίου", "Αλίμου", "Γλυφάδας", "Ελληνικού – Αργυρούπολης",
                "Μοσχάτου – Ταύρου", "Νέας Σμύρνης", "Παλαιού Φαλήρου", "Αχαρνών",
                "Βάρης – Βούλας – Βουλιαγμένης", "Διονύσου", "Κρωπίας",
                "Λαυρεωτικής", "Μαραθώνα", "Μαρκοπούλου Μεσογαίας", "Παιανίας", "Παλλήνης",
                "Ραφήνας – Πικερμίου", "Σαρωνικού", "Σπάτων", "Ωρωπού", "Ελευσίνας", "Ασπροπύργου",
                "Μάνδρας – Ειδυλλίας", "Μεγαρέων", "Φυλής", "Πειραιώς", "Κερατσινίου – Δραπετσώνας",
                "Κορυδαλλού", "Νίκαιας – Αγίου Ιωάννη Ρέντη", "Περάματος", "Σαλαμίνος", "Αγκιστρίου",
                "Αίγινας", "Κυθήρων", "Πόρου", "Σπετσών", "Τροιζηνίας", "Ύδρας");

        municipalityCoInput.setItems(municipalityInput.getItems());
        municipalityCoUnInput.setItems(municipalityInput.getItems());
        municipalityEditInput.setItems(municipalityInput.getItems());
        chooseTableComboBox.getSelectionModel().select("Select Table");
        chooseTableComboBox.getItems().addAll("Persons", "Cases", "Contacts");

        chooseColumnComboBox.getSelectionModel().select("Select Column");
        chooseColumnComboBox.getItems().addAll("ΑΦΜ", "First Name", "Last Name", "Phone Number",
                "Age", "Municipality", "Address", "Street Number", "Zip Code", "Diagnosis Date",
                "Recovery Date", "Death Date");


    }

}


